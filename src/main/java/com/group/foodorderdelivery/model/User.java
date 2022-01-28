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
public class User extends Account {

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Orders> orders;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Position orderLocation;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "user_favourite_food",
            joinColumns =@JoinColumn(name="user_id",referencedColumnName = "id"),
            inverseJoinColumns =@JoinColumn(name="food_id",referencedColumnName="id"))
    private List<Food> favouriteFood;

}
