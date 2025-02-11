
package com.campus.exam.order.infrastructure;

import com.campus.exam.order.domain.Order;
import com.campus.exam.order.domain.OrderRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaOrderRepository extends JpaRepository<Order, Long>, OrderRepository{

}
