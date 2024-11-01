package org.example.service;

import org.example.model.Plant;

import java.util.List;

public interface PlantService {
    void addPlant(Plant plant);

    void removePlant(String name);

    List<Plant> getAllPlants();
}