package com.tech.user_service.repositories;

import com.tech.user_service.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
