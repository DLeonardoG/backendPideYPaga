package com.campus.exam.orderstatus.application;

import com.campus.exam.orderstatus.domain.OrderStatus;
import com.campus.exam.orderstatus.domain.OrderStatusDTO;
import com.campus.exam.orderstatus.domain.OrderStatusRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderStatusServiceImpl {

    
    private final OrderStatusRepository orderStatusRepository;

    @Autowired
    public OrderStatusServiceImpl(OrderStatusRepository orderStatusRepository) {
        this.orderStatusRepository = orderStatusRepository;
    }

    


    public List<OrderStatusDTO> findAll() {
        return orderStatusRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<OrderStatusDTO> findById(Long id) {
        return orderStatusRepository.findById(id)
                .map(this::convertToDTO);

    }

    public OrderStatusDTO save(OrderStatusDTO orderStatusDTO) {
        OrderStatus orderStatus = convertToEntity(orderStatusDTO);
        OrderStatus savedOrderStatus = orderStatusRepository.save(orderStatus);
        return convertToDTO(savedOrderStatus);
    }

    private OrderStatusDTO convertToDTO(OrderStatus orderStatusDTO) {
        return new OrderStatusDTO(
                orderStatusDTO.getId(),
                orderStatusDTO.getName());
    }

    private OrderStatus convertToEntity(OrderStatusDTO orderStatusDTO) {
        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setId(orderStatusDTO.getId());
        orderStatus.setName(orderStatusDTO.getName());
        return orderStatus;
    }

}
