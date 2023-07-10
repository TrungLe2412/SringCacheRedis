package com.example.hibernatedemo.service.impl;

import com.example.hibernatedemo.UserRepository;
import com.example.hibernatedemo.model.UserEntity;
import com.example.hibernatedemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
 //chỉ định tên của cache mặc định trong lớp mà mình dang xử lý
@CacheConfig(cacheNames = "user")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Cacheable(key = "'cache1'")
    public List<UserEntity> getAll() {
        List<UserEntity> userEntity = userRepository.findAll();
        return userEntity;
    }

    @Override
    @CachePut(key = "'cache1'")
    public List<UserEntity> addUser(UserEntity user) {
        userRepository.save(user);
        //tra lai du lieu cho @CachePut cap nhat lai dl moi vao cache
        List<UserEntity> userEntity = userRepository.findAll();
        return userEntity;
    }

    @Override
    @CachePut(key = "'cache1'")
    public List<UserEntity> DelOne(Long userId) {
        userRepository.deleteById(userId);
        //tra lai du lieu cho @CachePut cap nhat lai dl moi vao cache
        List<UserEntity> userEntity = userRepository.findAll();
        return userEntity;

    }

    //phương thức update tương tự
}
