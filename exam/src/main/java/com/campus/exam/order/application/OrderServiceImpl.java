/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.campus.exam.order.application;

import com.campus.exam.order.domain.Order;
import com.campus.exam.order.domain.OrderDTO;
import com.campus.exam.order.domain.OrderRepository;
import com.campus.exam.order.infrastructure.JpaOrderRepository;
import com.campus.exam.orderstatus.domain.OrderStatus;
import com.campus.exam.orderstatus.domain.OrderStatusRepository;
import com.campus.exam.user.domain.User;
import com.campus.exam.user.domain.UserRepository;
import com.campus.exam.user.infrastructure.JpaUserRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderStatusRepository orderStatusRepository;

    public List<OrderDTO> findAll() {
        return orderRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

public Optional<OrderDTO> findById(Long id) {
    return orderRepository.findById(id).map(this::convertToDTO);
}

    public OrderDTO save(OrderDTO orderDTO) {
        Order order = convertToEntity(orderDTO);
        Order savedOrder = orderRepository.save(order);
        return convertToDTO(savedOrder);
    }

    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }

//    public List<OrderDTO> findOrderByUserId(Long userId) {
//        return orderRepository.findByUserId(userId).stream().map(this::convertToDTO).collect(Collectors.toList());
//    }

    private OrderDTO convertToDTO(Order order) {

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setDate(order.getDate());
        orderDTO.setIdUser(order.getOrderUser().getId());
        orderDTO.setOrderStatus(order.getOrderStatus().getName());
        orderDTO.setTotal(order.getTotal());

        return orderDTO;
    }

    private Order convertToEntity(OrderDTO orderDTO) {

        
        User user = userRepository.findById(orderDTO.getId())
                .orElseThrow(() -> new IllegalArgumentException("User no encontrada para id: "));
        OrderStatus orderStatus = orderStatusRepository.findByName(orderDTO.getOrderStatus());

        Order order = new Order();
        order.setId(orderDTO.getId());
        order.setDate(orderDTO.getDate());
        order.setOrderStatus(orderStatus);
        order.setOrderUser(user);
        order.setTotal(orderDTO.getTotal());
        return order;
    }

}
