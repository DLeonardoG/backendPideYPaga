
package com.campus.exam.product.infrastructure;

import com.campus.exam.product.domain.Product;
import com.campus.exam.product.domain.ProductRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaProductRepository extends JpaRepository<Product, Long>, ProductRepository {
    
}
