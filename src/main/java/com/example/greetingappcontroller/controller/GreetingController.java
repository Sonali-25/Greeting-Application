package com.example.greetingappcontroller.controller;


import com.example.greetingappcontroller.entity.Greeting;
import com.example.greetingappcontroller.entity.User;
import com.example.greetingappcontroller.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greet")
public class GreetingController {

    @Autowired


    private IGreetingService greetingService;

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "world") String name) {
        User user = new User(name,"Sahu");
        return greetingService.addGreeting(user);
    }

}
