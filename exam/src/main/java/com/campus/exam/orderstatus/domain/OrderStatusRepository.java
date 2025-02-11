
package com.campus.exam.orderstatus.domain;

import java.util.List;
import java.util.Optional;


public interface OrderStatusRepository {
    List<OrderStatus> findAll();

    OrderStatus save(OrderStatus orderStatus);

    Optional<OrderStatus> findById(Long id);

    void deleteById(Long id);

    Optional<OrderStatus> findByName (String type);
}
