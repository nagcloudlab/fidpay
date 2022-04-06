package com.example;

import com.fidypay.FidypayAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
//@Import(value={FidypayAutoConfiguration.class})
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.example","com.fidypay"})
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext=
        SpringApplication.run(Application.class, args);

        String fidypayBean=applicationContext.getBean("fidypay",String.class);
        System.out.println(fidypayBean);
    }
}
