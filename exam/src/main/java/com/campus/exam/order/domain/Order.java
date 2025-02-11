/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.campus.exam.order.domain;

import com.campus.exam.orderstatus.domain.OrderStatus;
import com.campus.exam.user.domain.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dated;
    private int total;
    
    @ManyToOne
    @JoinColumn(name = "status_id")
    private OrderStatus ordersStatus;
    
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private User orderUser;
    
    

    public Order(Long id, LocalDateTime dated, int total, OrderStatus ordersStatus, User orderUser) {
        this.id = id;
        this.dated = dated;
        this.total = total;
        this.ordersStatus = ordersStatus;
        this.orderUser = orderUser;
    }

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return dated;
    }

    public void setDate(LocalDateTime dated) {
        this.dated = dated;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public OrderStatus getOrderStatus() {
        return ordersStatus;
    }

    public void setOrderStatus(OrderStatus ordersStatus) {
        this.ordersStatus = ordersStatus;
    }

    public User getOrderUser() {
        return orderUser;
    }

    public void setOrderUser(User orderUser) {
        this.orderUser = orderUser;
    }
    
    
    
    
    
}
