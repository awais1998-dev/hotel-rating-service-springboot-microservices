package com.tech.rating_service.controllers;

import com.tech.rating_service.models.Rating;
import com.tech.rating_service.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatings(){
        return new ResponseEntity<List<Rating>>(ratingService.getAllRatings(), HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<Rating>> getAllByUserId(@PathVariable Long id){
        return new ResponseEntity<List<Rating>>(ratingService.getAllByUserId(id), HttpStatus.OK);
    }

    @GetMapping("/hotel/{id}")
    public ResponseEntity<List<Rating>> getAllByHotelId(@PathVariable Long id){
        return new ResponseEntity<List<Rating>>(ratingService.getAllByHotelId(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
        return new ResponseEntity<Rating>(ratingService.createRating(rating), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rating> getRatingById(@PathVariable Long id){
        return new ResponseEntity<Rating>(ratingService.getRatingById(id), HttpStatus.OK);
    }
}
