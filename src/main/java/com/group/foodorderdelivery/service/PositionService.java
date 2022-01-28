package com.group.foodorderdelivery.service;

import com.group.foodorderdelivery.model.Position;

import java.util.List;

public interface PositionService {
    List<Position> findAll();
    void save(Position position);
}
