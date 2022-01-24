package com.group.foodorderdelivery.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantManager extends Account {

    @OneToMany(mappedBy = "restaurantManager", cascade = CascadeType.ALL)
    private List<Restaurant> ownedRestaurant;

}
