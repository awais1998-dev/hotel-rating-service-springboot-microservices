package com.tech.user_service.external.services;

import com.tech.user_service.models.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "RATING-SERVICE")
public interface RatingInterface {

    @GetMapping("/api/ratings/user/{id}")
    List<Rating> getRatingsByUserId(@PathVariable Long id);
}
