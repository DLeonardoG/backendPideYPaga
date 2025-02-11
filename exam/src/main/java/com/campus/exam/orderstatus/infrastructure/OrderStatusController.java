
package com.campus.exam.orderstatus.infrastructure;

import com.campus.exam.orderstatus.application.OrderStatusServiceImpl;
import com.campus.exam.orderstatus.domain.OrderStatusDTO;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orderstatus")
public class OrderStatusController {
    
    private final OrderStatusServiceImpl orderStatusServiceImpl;

    
        @Autowired
    public OrderStatusController(OrderStatusServiceImpl orderStatusServiceImpl) {
        this.orderStatusServiceImpl = orderStatusServiceImpl;
    }
    
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrderStatusDTO> getAll() {
        return orderStatusServiceImpl.findAll();
    }
    
    @GetMapping("/{id}")
    public Optional findById(@PathVariable Long id){
        return orderStatusServiceImpl.findById(id);
    }
    
}
