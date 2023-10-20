package com.tech.hotel_service.repositories;

import com.tech.hotel_service.models.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
