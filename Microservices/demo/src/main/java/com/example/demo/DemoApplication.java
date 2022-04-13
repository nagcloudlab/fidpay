package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import javax.annotation.PostConstruct;

@SpringBootApplication
@RestController
public class DemoApplication {

    WebClient webClient;

    @PostConstruct
    public void init(){
        this.webClient = WebClient.create("https://jsonplaceholder.typicode.com");
    }

    @GetMapping("/todos")
    public Flux<Todo> getTodos(){
        String resourceUri="/todos?_limit=5";
        return webClient
                .get()
                .uri(resourceUri)
                .retrieve()
                .bodyToFlux(Todo.class);
    }


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
