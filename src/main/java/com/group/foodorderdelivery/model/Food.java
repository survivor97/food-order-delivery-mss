package com.group.foodorderdelivery.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int price;
    private int weight;

    @Enumerated(EnumType.STRING)
    private FoodCategory foodCategory;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany(mappedBy = "favouriteFood", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<User> user;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany(mappedBy = "foodList", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Orders> orders;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    private Restaurant restaurant;

}
