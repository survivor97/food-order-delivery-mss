package com.group.foodorderdelivery.service;

import com.group.foodorderdelivery.model.Position;
import com.group.foodorderdelivery.repository.PositionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {

    private PositionRepository positionRepository;

    public PositionServiceImpl(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }

    @Override
    public void save(Position position) {
        positionRepository.save(position);
    }

}
