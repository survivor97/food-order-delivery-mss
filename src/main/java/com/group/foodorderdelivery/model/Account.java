package com.group.foodorderdelivery.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public abstract class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String username;
    protected String password;
    protected Role role;

}
