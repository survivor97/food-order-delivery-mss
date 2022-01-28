package com.group.foodorderdelivery.repository;

import com.group.foodorderdelivery.model.Position;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PositionRepository extends CrudRepository<Position, Long> {
    List<Position> findAll();
}
