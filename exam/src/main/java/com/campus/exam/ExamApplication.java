package com.campus.exam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ExamApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ExamApplication.class, args);

    }

}
