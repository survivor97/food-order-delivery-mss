package com.group.foodorderdelivery.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @OneToOne(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private Position location;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Food> food;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Review> reviews;

    @ManyToOne
    private RestaurantManager restaurantManager;

    @OneToOne
    private Orders orders;

}
