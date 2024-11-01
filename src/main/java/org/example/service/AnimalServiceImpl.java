package org.example.service;

import org.example.model.Animal;
import org.example.repository.AnimalRepository;

import java.util.List;

public class AnimalServiceImpl implements AnimalService {
    private final AnimalRepository animalRepository;
    private final PlantService plantService;

    @Override
    public void addAnimal(Animal animal) {
        animalRepository.save(animal);
    }

    @Override
    public void removeAnimal(String name) {
        animalRepository.delete(name);
    }

    @Override
    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    public AnimalServiceImpl(AnimalRepository animalRepository, PlantService plantService) {
        this.animalRepository = animalRepository;
        this.plantService = plantService;
    }
}