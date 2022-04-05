package com.example;

import com.example.config.TransferServiceConfiguration;
import com.example.service.TransferService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        //1. init / booting phase
        ConfigurableApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(TransferServiceConfiguration.class);
        try {
            // 2. use phase
            TransferService transferService = applicationContext.getBean(TransferService.class);
            transferService.transfer(1000.00, "1", "2");

        } catch (Exception e) {
            System.out.println("ex-" + e.getMessage());
        }
        // 3. destroy phase
    }
}
