package com.fidypay;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FidypayGreetController {

//    @Value("${fidypay.greet.message:hello}")
//    private String message;
//
//    @Value("${fidypay.greet.messages}")
//    private List<String> messages;

    private FidypayGreetProperties fidypayGreetProperties;

    public FidypayGreetController(FidypayGreetProperties fidypayGreetProperties) {
        this.fidypayGreetProperties = fidypayGreetProperties;
    }


    @RequestMapping(method = RequestMethod.GET,value = "/api/greet")
    public String doGreet(){
        System.out.println(fidypayGreetProperties.getMessages());
        return fidypayGreetProperties.getMessage();
    }

}
