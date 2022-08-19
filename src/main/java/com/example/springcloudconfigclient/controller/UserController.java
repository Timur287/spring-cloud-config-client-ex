package com.example.springcloudconfigclient.controller;

import com.example.springcloudconfigclient.entity.User;
import com.example.springcloudconfigclient.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private UserService service;

    @GetMapping("/getById/{id}")
    public User getById(@PathVariable Long id){
        return service.getUser(id).orElseThrow(IllegalArgumentException::new);
    }

    @GetMapping("/getAll")
    public List<User> getAllUsers(){
        return service.getAllUsers();
    }

    @PostMapping("/save")
    public User saveUser(@RequestBody User user){
        return service.saveUser(user);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteUserById(@PathVariable Long id){
        service.deleteUser(id);
    }
}
