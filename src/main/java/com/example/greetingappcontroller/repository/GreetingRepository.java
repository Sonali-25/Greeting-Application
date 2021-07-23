package com.example.greetingappcontroller.repository;


import com.example.greetingappcontroller.entity.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetingRepository extends JpaRepository<Greeting,Long> {
}
