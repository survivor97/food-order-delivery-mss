package com.group.foodorderdelivery.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private DeliveryUser deliveryUser;

    @ManyToOne
    private User user;

    @OneToOne(mappedBy = "orders", cascade = CascadeType.ALL)
    private Restaurant restaurant;

    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
    private List<Food> foodList;

    private LocalDateTime orderDateTime;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

}
