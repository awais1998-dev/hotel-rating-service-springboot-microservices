package com.tech.user_service.controller;

import com.tech.user_service.models.User;
import com.tech.user_service.services.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
//    @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
//    @Retry(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
    @RateLimiter(name = "ratingHotelLimiter", fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        return new ResponseEntity<User>(userService.getUserById(id), HttpStatus.OK);
    }

    public ResponseEntity<User> ratingHotelFallback(Long id, Exception ex){
        logger.info("ratingHotelFallback method is called because some service is down : ", ex.getMessage());
        User user = new User();
        user.setId(132L);
        user.setName("Dummy");
        user.setEmail("dummy@gmail.com");
        user.setAbout("About section");
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
}
