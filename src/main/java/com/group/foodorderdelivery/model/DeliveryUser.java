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
public class DeliveryUser extends Account {

    @OneToMany(mappedBy = "deliveryUser", cascade = CascadeType.ALL)
    private List<Orders> receivedOrders;

}
