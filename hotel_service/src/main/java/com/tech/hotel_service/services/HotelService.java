package com.tech.hotel_service.services;

import com.tech.hotel_service.models.Hotel;

import java.util.List;

public interface HotelService {

    List<Hotel> getAllHotels();
    Hotel createHotel(Hotel hotel);
    Hotel getHotelById(Long id);
}
