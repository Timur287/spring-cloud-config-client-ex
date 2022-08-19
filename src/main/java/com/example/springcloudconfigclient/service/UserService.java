package com.example.springcloudconfigclient.service;

import com.example.springcloudconfigclient.entity.User;
import com.example.springcloudconfigclient.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository repository;

    public List<User> getAllUsers(){
        return repository.findAll();
    }

    public Optional<User> getUser(Long id){
        return repository.findById(id);
    }

    public User saveUser(User user){
        return repository.save(user);
    }

    public User updateUser(User user){
        return repository.save(user);
    }

    public void deleteUser(Long id){
        repository.deleteById(id);
    }
}
