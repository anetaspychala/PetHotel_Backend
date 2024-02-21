package org.example.pet.controller;

import lombok.RequiredArgsConstructor;
import org.example.pet.service.UserService;
import org.example.pet.model.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth/admin")
public class AdminPanel {

    private final UserService userService;
    @GetMapping("/allUsers")
    public List<User> listUsers(User user){
        List<User> userList = userService.getUserList();
        return userList;
    }
}
