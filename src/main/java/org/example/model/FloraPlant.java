package org.example.model;

public enum FloraPlant {
    GRASS("Трава"),
    WOLF("Клевер"),
    CABBAGE("Капуста"),
    LEAVES("Листья"),
    FRUITS("Фрукты"),
    TREE("Дерево");

    private final String plantName;

    public String getPlantName() {
        return plantName;
    }

    FloraPlant(String plantName) {
        this.plantName = plantName;
    }
}