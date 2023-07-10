package com.example.hibernatedemo.controller;

import com.example.hibernatedemo.model.UserEntity;
import com.example.hibernatedemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/post")
    public String addOne (@RequestBody UserEntity data){
        userService.addUser(data);
        return "add thanh cong";
    }
    @DeleteMapping("/del")
    public  String Delone (@RequestBody Long userId){
        userService.DelOne(userId);
        return "xoa thanh cong";
    }

    @CacheEvict(value = "user", allEntries = true)
    @GetMapping("/clearCache")
    public String clearCache() {
        return "Cache cleared";
    }
}
