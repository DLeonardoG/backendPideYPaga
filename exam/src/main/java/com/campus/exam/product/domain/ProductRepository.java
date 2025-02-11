package com.campus.exam.product.domain;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository {

    List<Product> findAll();

    Product save(Product product);

    Optional<Product> findById(Long id);

    void deleteById(Long id);

    Optional<Product> findByName(String type);
}
