/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.campus.exam.order.infrastructure;

import com.campus.exam.order.application.OrderServiceImpl;
import com.campus.exam.order.domain.OrderDTO;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    
    private final OrderServiceImpl orderServiceImpl;

    
    @Autowired
    public OrderController(OrderServiceImpl orderServiceImpl) {
        this.orderServiceImpl = orderServiceImpl;
    }
    
    @GetMapping("/orders/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<OrderDTO> getAllOrders(@PathVariable Long id) {
        return orderServiceImpl.findOrdersByUserId(id);
    }
    
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrderDTO> getAll() {
        return orderServiceImpl.findAll();
    }
    
    @GetMapping("/{id}")
    public Optional findById(@PathVariable Long id){
        return orderServiceImpl.findById(id);
    }
    
    @PostMapping
    public OrderDTO createOrder(@RequestBody OrderDTO orderDTO) {
        return orderServiceImpl.save(orderDTO);
    }
    
     @PutMapping("/{id}")
    public OrderDTO updateOrder(@PathVariable Long id, @RequestBody OrderDTO orderDTO) {
        orderDTO.setId(id);
        return orderServiceImpl.save(orderDTO);
    }
    
    @PatchMapping("/{id}/status")
    public ResponseEntity<OrderDTO> updatePublicationDescription(
            @PathVariable Long id,
            @RequestBody Map<String, String> payload) {

        String newDescription = payload.get("estado");
        if(newDescription == null || newDescription.trim().isEmpty()){
            return ResponseEntity.badRequest().build();
        }

        OrderDTO updatedPublication = orderServiceImpl.updateDescription(id, newDescription);
        return ResponseEntity.ok(updatedPublication);
    }

    
}
