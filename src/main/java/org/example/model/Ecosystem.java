package org.example.model;

import java.util.List;

public class Ecosystem {
    private String ecosystemName;
    private String temperature;
    private String humidity;
    private String waterAmount;
    private List<Animal> animals;
    private List<Plant> plants;

    public String getEcosystemName() {
        return ecosystemName;
    }

    public void setEcosystemName(String ecosystemName) {
        this.ecosystemName = ecosystemName;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getWaterAmount() {
        return waterAmount;
    }

    public void setWaterAmount(String waterAmount) {
        this.waterAmount = waterAmount;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public List<Plant> getPlants() {
        return plants;
    }

    public void setPlants(List<Plant> plants) {
        this.plants = plants;
    }

    public Ecosystem() {
    }

    public Ecosystem(String ecosystemName, String temperature, String humidity, String waterAmount) {
        this.ecosystemName = ecosystemName;
        this.temperature = temperature;
        this.humidity = humidity;
        this.waterAmount = waterAmount;
    }

    public Ecosystem(String ecosystemName, String temperature, String humidity, String waterAmount, List<Animal> animals, List<Plant> plants) {
        this.ecosystemName = ecosystemName;
        this.temperature = temperature;
        this.humidity = humidity;
        this.waterAmount = waterAmount;
    }
}