package com.kodilla.spring.forum;

import org.springframework.stereotype.Component;

@Component
public class ForumUser {
    String username;

    public String getUsername() {
        return "John Smith";
    }

    public ForumUser() {
        this.username = "John Smith";
    }
}
