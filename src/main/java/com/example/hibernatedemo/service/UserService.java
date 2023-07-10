package com.example.hibernatedemo.service;


import com.example.hibernatedemo.model.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {


    List<UserEntity> getAll();


    List<UserEntity> addUser(UserEntity user);


    List<UserEntity> DelOne (Long userId);


}
