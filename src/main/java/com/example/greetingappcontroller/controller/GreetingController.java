package com.example.greetingappcontroller.controller;


import com.example.greetingappcontroller.entity.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greet")
public class GreetingController {
    private static final String template = " Hello , %s !";
    private final AtomicLong message = new AtomicLong();

    @GetMapping
    public Greeting showMessage(){
        return new Greeting(1,"Hii Sonali");
    }
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting((int) message.incrementAndGet(),
                String.format(template, "Sonali"));
    }
}
