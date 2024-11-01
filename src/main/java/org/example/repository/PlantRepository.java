package org.example.repository;

import org.example.model.Plant;

import java.util.List;

public interface PlantRepository {
    void save(Plant plant);

    void delete(String name);

    List<Plant> findAll();
}