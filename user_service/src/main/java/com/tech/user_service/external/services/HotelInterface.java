package com.tech.user_service.external.services;

import com.tech.user_service.models.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelInterface {

    @GetMapping("/api/hotels/{id}")
    Hotel getHotelById(@PathVariable Long id);
}
