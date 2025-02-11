
package com.campus.exam.product.application;

import com.campus.exam.product.domain.Product;
import com.campus.exam.product.domain.ProductDTO;
import com.campus.exam.product.domain.ProductRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl {
    
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    
    public List<ProductDTO> findAll() {
        return productRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<ProductDTO> findById(Long id) {
        return productRepository.findById(id)
                .map(this::convertToDTO);

    }

   public ProductDTO save(ProductDTO productDTO) {
        Product orderStatus = convertToEntity(productDTO);
        Product savedProduct = productRepository.save(orderStatus);
        return convertToDTO(savedProduct);
    }

    private ProductDTO convertToDTO(Product productDTO) {
        return new ProductDTO(
                productDTO.getId(),
                productDTO.getName(),
                productDTO.getDescription(),
                productDTO.getPrice());
    }
    private Product convertToEntity(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());        
        return product;
    }
}
