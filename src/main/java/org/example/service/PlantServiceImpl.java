package org.example.service;

import org.example.model.Plant;
import org.example.repository.PlantRepository;

import java.util.List;

public class PlantServiceImpl implements PlantService {
    private final PlantRepository plantRepository;

    public PlantServiceImpl(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    @Override
    public void addPlant(Plant plant) {
        plantRepository.save(plant);
    }

    @Override
    public void removePlant(String name) {
        plantRepository.delete(name);
    }

    @Override
    public List<Plant> getAllPlants() {
        return plantRepository.findAll();
    }
}