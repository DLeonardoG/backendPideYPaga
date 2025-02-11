/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.campus.exam.order.domain;

import com.campus.exam.orderstatus.domain.OrderStatus;
import java.time.LocalDateTime;

/**
 *
 * @author camper
 */
public class OrderDTO {

    private Long id;
    private LocalDateTime date;
    private int total;
    private String orderStatus;
    private Long idUser;
    
    

    public OrderDTO(Long id, LocalDateTime date, int total, String orderStatus, Long idUser) {
        this.id = id;
        this.date = date;
        this.total = total;
        this.orderStatus = orderStatus;
        this.idUser = idUser;
    }

    public OrderDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
    
    

}
