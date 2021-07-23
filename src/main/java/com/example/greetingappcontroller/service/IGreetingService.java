package com.example.greetingappcontroller.service;

import com.example.greetingappcontroller.entity.Greeting;
import com.example.greetingappcontroller.entity.User;
public interface IGreetingService {
    Greeting addGreeting(User user);
}
