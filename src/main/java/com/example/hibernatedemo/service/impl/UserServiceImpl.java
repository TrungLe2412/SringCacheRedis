package com.example.hibernatedemo.service.impl;

import com.example.hibernatedemo.UserRepository;
import com.example.hibernatedemo.model.UserEntity;
import com.example.hibernatedemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Cacheable(value = "user", key = "#root.methodName" )
    public List<UserEntity> getAll() {
        List<UserEntity> userEntity = userRepository.findAll();
        return userEntity;
    }

    @Override
    @CachePut(value = "user", key = "'getAll'" )
    public String addUser(UserEntity user) {
        userRepository.save(user);
        return null;
    }
}
