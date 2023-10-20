package com.tech.rating_service.services;

import com.tech.rating_service.models.Rating;

import java.util.List;

public interface RatingService {
    List<Rating> getAllRatings();
    List<Rating> getAllByUserId(Long id);
    List<Rating> getAllByHotelId(Long id);
    Rating createRating(Rating rating);
    Rating getRatingById(Long id);
}
