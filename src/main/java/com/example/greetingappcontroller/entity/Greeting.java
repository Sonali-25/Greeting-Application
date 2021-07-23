package com.example.greetingappcontroller.entity;

import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class Greeting {
    @Id
    private long id;
    private String message;

    public Greeting(long id, String message) {
        this.id = id;
        this.message = message;
    }

    public Greeting() {
        id = 0;
        message = "";
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
