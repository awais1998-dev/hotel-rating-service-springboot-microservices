package com.tech.hotel_service.services;

import com.tech.hotel_service.exceptions.ResourceNotFoundException;
import com.tech.hotel_service.models.Hotel;
import com.tech.hotel_service.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel createHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel getHotelById(Long id) {
        return hotelRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Hotel not found with id : "+ id)
        );
    }
}
