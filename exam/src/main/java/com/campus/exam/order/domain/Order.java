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
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "ordenes")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dated;
    private int total;
    
    private String orderStatus;
    
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private User userO;

    public Order(Long id, LocalDateTime dated, int total, String orderStatus, User userO) {
        this.id = id;
        this.dated = dated;
        this.total = total;
        this.orderStatus = orderStatus;
        this.userO = userO;
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

    public User getOrderUser() {
        return userO;
    }

    public void setOrderUser(User userO) {
        this.userO = userO;
    }

    public LocalDateTime getDated() {
        return dated;
    }

    public void setDated(LocalDateTime dated) {
        this.dated = dated;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
    
    
    
    
    
    
}
