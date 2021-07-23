package com.example.greetingappcontroller.controller;


import com.example.greetingappcontroller.entity.Greeting;
import com.example.greetingappcontroller.entity.User;
import com.example.greetingappcontroller.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greet")
public class GreetingController {

    @Autowired


    private IGreetingService greetingService;

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "world") String name) {
        User user = new User("firstName","lastName");
        return greetingService.addGreeting(user);
    }
    @GetMapping("/greeting/{id}")
    public Greeting getById(@PathVariable Long id){
        return greetingService.getGreetingById(id);
    }
    @GetMapping("/greetings")
    public List<Greeting> getAllGreetings(){
        return greetingService.getAll();
    }
    @PutMapping("/greeting/{id}")
    public Greeting updateById(@PathVariable Long id, @RequestBody User user){
        return greetingService.updateGreeting(id,user);
    }

}
