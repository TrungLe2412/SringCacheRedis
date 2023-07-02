package com.example.hibernatedemo;

import com.example.hibernatedemo.model.UserEntity;
import com.example.hibernatedemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/get")
    public List<UserEntity> getAll(){
        return userService.getAll();
    }

    @CacheEvict(value = "user", allEntries = true)
    @GetMapping("/clearCache")
    public String clearCache() {
        return "Cache cleared";
    }
}
