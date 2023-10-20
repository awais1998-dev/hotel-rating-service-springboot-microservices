package com.tech.user_service.services;

import com.tech.user_service.exception.ResourceNotFoundException;
import com.tech.user_service.external.services.HotelInterface;
import com.tech.user_service.external.services.RatingInterface;
import com.tech.user_service.models.Hotel;
import com.tech.user_service.models.Rating;
import com.tech.user_service.models.User;
import com.tech.user_service.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private HotelInterface hotelInterface;
    @Autowired
    private RatingInterface ratingInterface;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User not found with id : "+ id)
        );
//        List<Rating> ratings = Arrays.asList(restTemplate.getForObject("http://RATING-SERVICE/api/ratings/user/"+user.getId(), Rating[].class));
        List<Rating> ratings = ratingInterface.getRatingsByUserId(user.getId());
        logger.info("{} ", ratings);
        List<Rating> ratingList = ratings.stream().map(rating -> {
//            Hotel hotel = restTemplate.getForObject("http://HOTEL-SERVICE/api/hotels/"+rating.getHotelId(), Hotel.class);
            Hotel hotel = hotelInterface.getHotelById(rating.getHotelId());
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());
        user.setRatings(ratingList);
        return user;
    }
}
