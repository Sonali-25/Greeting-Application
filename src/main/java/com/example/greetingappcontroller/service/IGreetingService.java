package com.example.greetingappcontroller.service;

import com.example.greetingappcontroller.entity.Greeting;
import com.example.greetingappcontroller.entity.User;

import java.util.List;

public interface IGreetingService {
    Greeting addGreeting(User user);
    Greeting getGreetingById(long id);
    List<Greeting> getAll();
}
