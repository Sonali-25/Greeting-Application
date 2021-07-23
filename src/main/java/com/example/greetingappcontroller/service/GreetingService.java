package com.example.greetingappcontroller.service;

import com.example.greetingappcontroller.entity.Greeting;
import com.example.greetingappcontroller.entity.User;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;


@Service
public class GreetingService implements IGreetingService{

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    @Override
    public Greeting addGreeting(User user) {
        String message = "Hello World";
        return new Greeting(counter.incrementAndGet(),message);
    }
}
