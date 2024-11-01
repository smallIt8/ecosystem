package org.example.model;

public enum FaunaAnimal {
    LION("Лев"),
    WOLF("Волк"),
    FOX("Лисица"),
    DEER("Олень"),
    HARE("Заяц"),
    ELEPHANT("Слон");

    private final String animalName;

    public String getAnimalName() {
        return animalName;
    }

    FaunaAnimal(String animalName) {
        this.animalName = animalName;
    }
}