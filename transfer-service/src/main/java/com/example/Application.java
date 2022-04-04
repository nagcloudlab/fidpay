package com.example;

import com.example.config.TransferServiceConfiguration;
import com.example.service.TransferService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        //1. init / booting phase

        ConfigurableApplicationContext applicationContext=
                new AnnotationConfigApplicationContext(TransferServiceConfiguration.class);

        // 2. use phase
        TransferService transferService=applicationContext.getBean(TransferService.class);
        transferService.transfer(100.00, "1", "2");

        // 3. destroy phase
        transferService = null;

    }
}
