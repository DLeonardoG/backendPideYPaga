package com.campus.exam;

import com.campus.exam.product.application.ProductServiceImpl;
import com.campus.exam.product.domain.Product;
import com.campus.exam.product.domain.ProductDTO;
import com.campus.exam.user.application.UserServiceImpl;
import com.campus.exam.user.domain.RegisterDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ExamApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ExamApplication.class, args);

                UserServiceImpl userServiceImpl = context.getBean(UserServiceImpl.class);
                ProductServiceImpl productServiceImpl = context.getBean(ProductServiceImpl.class);
    
                
//                ProductDTO product = new ProductDTO();
//                product.setDescription("hoahaojgag");
//                product.setName("dbhfjdfhf");
//                product.setPrice(300);
//                
//                productServiceImpl.save(product);
//                
                RegisterDTO userDTO = new RegisterDTO();
                
                userDTO.setAdmin("si");
                userDTO.setEmail("admin@gmail.com");
                userDTO.setName("admin");
                userDTO.setPassword("123");
                
                userServiceImpl.register(userDTO);
    }

}
