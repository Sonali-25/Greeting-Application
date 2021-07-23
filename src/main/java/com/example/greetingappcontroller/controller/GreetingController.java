package com.example.greetingappcontroller.controller;


import com.example.greetingappcontroller.entity.Greeting;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/greeting/post")
    public Greeting postGreeting(@RequestBody Greeting greeting){
        return greeting;
    }
    @PutMapping("/greeting/put/{id}")
    public Greeting putGreeting(@PathVariable long id, @RequestParam(value="name") String name){
        return new Greeting(id,String.format(template,name));
    }
}
