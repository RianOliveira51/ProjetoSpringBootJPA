package com.example.portaChamados.service;

import com.example.portaChamados.entities.User;
import com.example.portaChamados.repositories.UserRepository;
import com.example.portaChamados.service.exceptions.ResourceNotFoundExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findALL() {
        return userRepository.findAll();
    }

    public User findById(Integer id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundExeption(id));
    }

    public User insert(User obj) {
        return obj = userRepository.save(obj);
    }
}
