package com.example.greetingappcontroller.service;

import com.example.greetingappcontroller.entity.Greeting;
import com.example.greetingappcontroller.entity.User;
import com.example.greetingappcontroller.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


@Service
public class GreetingService implements IGreetingService{

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    GreetingRepository greetingRepository;
    @Override
    public Greeting addGreeting(User user) {
        String message = String.format(template,user.toString().isEmpty()?"Hello World":user.toString());
        return greetingRepository.save(new Greeting(counter.incrementAndGet(),message));
    }
    @Override
    public Greeting getGreetingById(long id) {
        return greetingRepository.findById(id).get();
    }
    @Override
    public List<Greeting> getAll() {
        return greetingRepository.findAll();
    }
    @Override
    public Greeting updateGreeting(long id,User user) {
        String message = String.format(template,user.toString());
        return greetingRepository.findById(id).
                map(greeting -> {
                    greeting.setMessage(message);
                    return this.greetingRepository.save(greeting);
                }).get();
    }
    @Override
    public Greeting deleteGreeting(long id) {
        return greetingRepository.findById(id).
                map(greeting -> {
                    this.greetingRepository.deleteById(id);
                    return greeting;
                }).get();
    }

}
