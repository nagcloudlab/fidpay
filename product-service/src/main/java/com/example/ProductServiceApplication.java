package com.example;

import com.example.repository.ProductEntity;
import com.example.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//@SpringBootApplication
// or
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class ProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ProductService productService) {
        return args -> {
            try {
//                ProductEntity productEntity = new ProductEntity();
//                productEntity.setName("product-2");
//                productEntity.setPrice(200.00);
//                productService.createProduct(productEntity);

//                ProductEntity product = productService.getProduct(1);
//                System.out.println(product);

//                productService.deleteProduct(1);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        };
    }

}
