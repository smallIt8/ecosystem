package org.example.repository;

import org.example.model.Animal;

import java.util.List;

public interface AnimalRepository {
    void save(Animal animal);

    void delete(String name);

    List<Animal> findAll();
}