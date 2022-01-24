package com.group.foodorderdelivery.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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



    @ManyToOne
    private User user;

    @ManyToOne
    private Orders orders;

    @ManyToOne
    private Restaurant restaurant;

}
