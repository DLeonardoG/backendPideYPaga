
package com.campus.exam.orderstatus.domain;

public class OrderStatusDTO {
    private Long id;
    private String name;

    public OrderStatusDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public OrderStatusDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
}
