package org.example.repository;

import org.example.model.Animal;

import java.util.ArrayList;
import java.util.List;

public class AnimalRepositoryImpl implements AnimalRepository {
    private final List<Animal> animals = new ArrayList<>();

    @Override
    public void save(Animal animal) {

    }

    @Override
    public void delete(String name) {

    }

    @Override
    public List<Animal> findAll() {
        return List.of();
    }
}