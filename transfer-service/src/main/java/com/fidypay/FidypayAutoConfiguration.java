package com.fidypay;

import org.springframework.boot.autoconfigure.condition.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
//@ConditionalOnClass(name = "com.fidypay.FidypayService")
@ConditionalOnMissingClass(value = "com.fidypay.FidypayService")
public class FidypayAutoConfiguration {

    @Profile("fidypay")
    @ConditionalOnMissingBean(name="fidy1")
    @ConditionalOnProperty(prefix = "fidypay",name = "transfer.type")
    @Bean
    public String fidypay() {
        return "FIDYPAY";
    }


}
