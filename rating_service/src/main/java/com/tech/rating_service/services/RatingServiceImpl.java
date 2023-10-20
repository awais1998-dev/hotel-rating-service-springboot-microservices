package com.tech.rating_service.services;

import com.tech.rating_service.models.Rating;
import com.tech.rating_service.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService{

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getAllByUserId(Long id) {
        return ratingRepository.findAllByUserId(id);
    }

    @Override
    public List<Rating> getAllByHotelId(Long id) {
        return ratingRepository.findAllByHotelId(id);
    }

    @Override
    public Rating createRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public Rating getRatingById(Long id) {
        return ratingRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Resource not found")
        );
    }
}
