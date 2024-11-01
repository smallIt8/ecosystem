package org.example.model;

public class Animal {
    private String name;
    private String species;
    private double weight;
    private double height;

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public Animal(String name, String species, double weight, double height) {
        this.name = name;
        this.species = species;
        this.weight = weight;
        this.height = height;
    }
}