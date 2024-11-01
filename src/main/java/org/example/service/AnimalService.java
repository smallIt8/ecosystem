package org.example.service;

import org.example.model.Animal;

import java.util.List;

public interface AnimalService {
    void addAnimal(Animal animal);

    void removeAnimal(String name);

    List<Animal> getAllAnimals();
}