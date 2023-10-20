package com.tech.hotel_service.controllers;

import com.tech.hotel_service.models.Hotel;
import com.tech.hotel_service.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels(){
        return new ResponseEntity<List<Hotel>>(hotelService.getAllHotels(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        return new ResponseEntity<Hotel>(hotelService.createHotel(hotel), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable Long id){
        return new ResponseEntity<Hotel>(hotelService.getHotelById(id), HttpStatus.OK);
    }
}
