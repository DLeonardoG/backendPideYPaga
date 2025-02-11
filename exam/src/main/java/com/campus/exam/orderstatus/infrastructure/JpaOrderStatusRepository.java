
package com.campus.exam.orderstatus.infrastructure;

import com.campus.exam.orderstatus.domain.OrderStatus;
import com.campus.exam.orderstatus.domain.OrderStatusRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaOrderStatusRepository extends JpaRepository<OrderStatus, Long>, OrderStatusRepository{
}
