package com.tech.rating_service.repositories;

import com.tech.rating_service.models.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Long> {

    List<Rating> findAllByUserId(Long id);
    List<Rating> findAllByHotelId(Long id);
}
