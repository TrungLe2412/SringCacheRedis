package com.example.hibernatedemo;


import com.example.hibernatedemo.controller.UserController;
import com.example.hibernatedemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@Slf4j
//Annotation @EnableCaching là bắt buộc,
// nó sử dụng để spring context có thể tìm được các annotation @Cacheable, @CacheEvict, @CachePut
//@EnableCaching
//public class CacheDemoApplication implements CommandLineRunner {

public class CacheDemoApplication  {

//    private static final Logger logger = LoggerFactory.getLogger(CacheDemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CacheDemoApplication.class, args);
    }

//    @Autowired
//    private UserService userService;
//    @Autowired
//    private UserController userController;
//    @Override
//    public void run(String... args) throws Exception {
//        logger.info("------------------ demo @Cacheable --------------------");
//        logger.info("find user fist time []", userService.getAll());
//        logger.info("find user second time []", userService.getAll());
//
//        logger.info("------------------ demo @CacheEvict --------------------");
//        userController.clearCache();
//        logger.info("find user fist time after clear[]", userService.getAll());
//
//
//    }

}



