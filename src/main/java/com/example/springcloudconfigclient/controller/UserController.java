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

    @GetMapping("/hi")
    public String hello(){
        return "Hello heroku!";
    }

    @GetMapping("/getById/{id}")
    public User getById(@PathVariable Long id){
        return service.getUser(id).orElseThrow(IllegalArgumentException::new);
    }

    @GetMapping("/getAll")
    public List<User> getAllUsers(){
        return service.getAllUsers();
    }

    @PostMapping("/save")
    public User saveUser(@RequestParam String username, @RequestParam Long age, @RequestParam String sex){
        User user = User.builder()
                .username(username)
                .age(age)
                .sex(sex)
                .build();
        return service.saveUser(user);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteUserById(@PathVariable Long id){
        service.deleteUser(id);
    }
}
