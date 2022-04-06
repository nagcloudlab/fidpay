package com.example.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SomeService {

    @Transactional(
            propagation = Propagation.MANDATORY
    )
    public void someMethod(){
        throw new RuntimeException();
    }

}
