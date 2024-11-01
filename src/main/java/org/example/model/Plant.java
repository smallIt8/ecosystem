package org.example.model;

public class Plant {
    private String name;
    private String type;
    private double height;

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getHeight() {
        return height;
    }

    public Plant(String name, String type, double height) {
        this.name = name;
        this.type = type;
        this.height = height;
    }
}