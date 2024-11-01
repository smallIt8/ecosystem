package org.example.repository;

import org.example.model.Plant;

import java.util.ArrayList;
import java.util.List;

public class PlantRepositoryImpl implements PlantRepository {
    private final List<Plant> plants = new ArrayList<>();

    @Override
    public void save(Plant plant) {

    }

    @Override
    public void delete(String name) {

    }

    @Override
    public List<Plant> findAll() {
        return List.of();
    }
}