package com.group.foodorderdelivery.service;

import com.group.foodorderdelivery.model.Restaurant;
import com.group.foodorderdelivery.model.User;
import com.group.foodorderdelivery.repository.RestaurantRepository;
import com.group.foodorderdelivery.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private Logger LOGGER = LoggerFactory.getLogger(RestaurantServiceImpl.class);

    private double maximumNearbyDistance;

    private RestaurantRepository restaurantRepository;

    private UserRepository userRepository;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository, UserRepository userRepository, @Value("${maximumNearbyDistance}") double maximumNearbyDistance) {
        this.restaurantRepository = restaurantRepository;
        this.userRepository = userRepository;
        this.maximumNearbyDistance = maximumNearbyDistance;
    }

    @Override
    public void save(Restaurant restaurant) {
        LOGGER.info("Saving restaurant with name {" + restaurant.getName() + "}...");
        restaurantRepository.save(restaurant);
    }

    @Override
    public List<Restaurant> findAll() {
        LOGGER.info("Getting all restaurants list...");
        return restaurantRepository.findAll();
    }

    @Override
    public Optional<Restaurant> findById(Long id) {
        return restaurantRepository.findById(id);
    }

    @Override
    public List<Restaurant> findByNameContaining(String keyword) {
        return restaurantRepository.findByNameContaining(keyword);
    }

    @Override
    public List<Restaurant> findByFoodNameContaining(String keyword) {
        return restaurantRepository.findByFoodNameContaining(keyword);
    }

    @Override
    public List<Restaurant> findNearbyUser() {
        LOGGER.info("Getting all restaurants nearby user...");
        LOGGER.info("Finding current user...");

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<GrantedAuthority> authorities = (List<GrantedAuthority>) ((UserDetails) principal).getAuthorities();
        String username = ((UserDetails)principal).getUsername();
        String role = authorities.get(0).toString();

        if(!role.equals("ROLE_USER")) {
            LOGGER.info("Current account role {" + role + "} is not USER!");
            return new ArrayList<Restaurant>();    //return empty list
        }

        User user = userRepository.findByUsername(username);

        if(user.getOrderLocation() == null) {
            LOGGER.info("User position not set!");
            return new ArrayList<Restaurant>();    //return empty list
        }

        List<Restaurant> restaurants = restaurantRepository.findAll();
        List<Restaurant> nearbyRestaurants = new ArrayList<>();

        for(int i=0; i<restaurants.size(); i++) {
            if(restaurants.get(i).getLocation() == null) {
                LOGGER.info("Restaurant " + i + " location: NOT SET");
                continue;
            }
            LOGGER.info("Restaurant " + i + " location: lat: " + restaurants.get(i).getLocation().getLatitude() + "; long: " + restaurants.get(i).getLocation().getLongitude());
            LOGGER.info("User " + user.getEmail() + " location: lat: " + user.getOrderLocation().getLatitude() + "; long: " + user.getOrderLocation().getLongitude());
            LOGGER.info("Distance: " + distanceInKm(
                    user.getOrderLocation().getLatitude(),
                    user.getOrderLocation().getLongitude(),
                    restaurants.get(i).getLocation().getLatitude(),
                    restaurants.get(i).getLocation().getLongitude()));

            if(Double.compare(distanceInKm(
                    user.getOrderLocation().getLatitude(),
                    user.getOrderLocation().getLongitude(),
                    restaurants.get(i).getLocation().getLatitude(),
                    restaurants.get(i).getLocation().getLongitude()), maximumNearbyDistance) <= 0) {
                nearbyRestaurants.add(restaurants.get(i));
            }
        }

        return nearbyRestaurants;
    }

    private double distanceInKm(double lat1, double lon1, double lat2, double lon2)
    {
        lon1 = Math.toRadians(lon1);
        lat1 = Math.toRadians(lat1);
        lon2 = Math.toRadians(lon2);
        lat2 = Math.toRadians(lat2);

        // Haversine formula
        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat / 2), 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.pow(Math.sin(dlon / 2),2);

        double c = 2 * Math.asin(Math.sqrt(a));

        // Radius of earth in kilometers. Use 3956
        // for miles
        double r = 6371;

        // calculate the result
        return(c * r);
    }

}
