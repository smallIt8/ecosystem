package org.example.service;

import org.example.model.*;
import org.example.repository.EcosystemRepository;
import org.example.util.Utils;
import org.example.util.constant.RegexConstant;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.example.util.constant.ExceptionMessage.*;
import static org.example.util.constant.ColorsConstant.INDIGO;
import static org.example.util.constant.ColorsConstant.RESET;
import static org.example.util.constant.ConsoleMenuConstant.*;

public class EcosystemServiceImpl implements EcosystemService {
    private final EcosystemRepository ecosystemRepository;
    private final AnimalService animalService;
    private final PlantService plantService;
    private final Scanner SCANNER = new Scanner(System.in);
    private String ecosystemName;
    private String temperature;
    private String humidity;
    private String availableWater;
    private List<Animal> animals;
    private List<Plant> plants;

    @Override
    public void create() {
        System.out.println(MENU_ECOSYSTEM_ADD);
        enterEcosystemName();
        enterTemperature();
        enterHumidity();
        enterAvailableWater();
        selectAnimals();
        selectPlants();
        Ecosystem ecosystem = new Ecosystem(ecosystemName, temperature, humidity, availableWater, animals, plants);
        ecosystemRepository.create(ecosystem);
        System.out.println(CREATED_ECOSYSTEM_MESSAGE);
        Utils.exit();
    }

    private void enterEcosystemName() {
        for (int i = 0; i < Utils.ITERATION_LOOP; i++) {
            System.out.print(ENTER_ECOSYSTEM_NAME);
            ecosystemName = SCANNER.nextLine();
            if (ecosystemName.matches(RegexConstant.ECOSYSTEM_NAME)) {
                if (ecosystemRepository.checkEcosystemName(ecosystemName)) {
                    if (i < Utils.ITERATION_LOOP_MESSAGE) {
                        System.out.println(ERROR_CREATION_ECOSYSTEM_NAME_MESSAGE);
                    } else {
                        Utils.exitByFromAttempts();
                    }
                } else {
                    break;
                }
            } else {
                if (i < Utils.ITERATION_LOOP_MESSAGE) {
                    System.out.println(ERROR_ENTER_ECOSYSTEM_NAME_MESSAGE);
                } else {
                    Utils.exitByFromAttempts();
                }
            }
        }
    }

    private void enterTemperature() {
        for (int i = 0; i < Utils.ITERATION_LOOP; i++) {
            System.out.print(ENTER_TEMPERATURE_YEAR);
            temperature = SCANNER.nextLine();
            if (!temperature.matches(RegexConstant.TEMPERATURE_REGEX)) {
                if (i < Utils.ITERATION_LOOP_MESSAGE) {
                    System.out.println(ERROR_ENTER_TEMPERATURE_MESSAGE);
                } else {
                    Utils.exitByFromAttempts();
                }
            } else {
                break;
            }
        }
    }

    private void enterHumidity() {
        for (int i = 0; i < Utils.ITERATION_LOOP; i++) {
            System.out.print(ENTER_HUMIDITY_COUNTRY);
            humidity = SCANNER.nextLine();
            if (!humidity.matches(RegexConstant.HUMIDITY_REGEX)) {
                if (i < Utils.ITERATION_LOOP_MESSAGE) {
                    System.out.println(ERROR_ENTER_HUMIDITY_MESSAGE);
                } else {
                    Utils.exitByFromAttempts();
                }
            } else {
                break;
            }
        }
    }

    private void enterAvailableWater() {
        for (int i = 0; i < Utils.ITERATION_LOOP; i++) {
            System.out.print(ENTER_AVAILABLE_WATER);
            availableWater = SCANNER.nextLine();
            if (!availableWater.matches(RegexConstant.AVAILABLE_WATER)) {
                if (i < Utils.ITERATION_LOOP_MESSAGE) {
                    System.out.println(ERROR_ENTER_AVAILABLE_WATER_MESSAGE);
                } else {
                    Utils.exitByFromAttempts();
                }
            } else {
                break;
            }
        }
    }

    private List<FaunaAnimal> selectAnimals() {
        List<FaunaAnimal> selectedAnimals = new ArrayList<>();
        System.out.println(ENTER_ANIMAL_NUMBER);
        int index = 1;
        for (FaunaAnimal animal : FaunaAnimal.values()) {
            System.out.println(index++ + ". " + animal.getAnimalName());
        }

        while (true) {
            System.out.print(ENTER_ANIMAL_NUMBER);
            int choice = SCANNER.nextInt();
            if (choice == 0) {
                break;
            } else if (choice > 0 && choice <= FaunaAnimal.values().length) {
                selectedAnimals.add(FaunaAnimal.values()[choice - 1]);
                System.out.println(FaunaAnimal.values()[choice - 1].getAnimalName() + " добавлен.");
            } else {
                System.out.println(ERROR_ENTER_ANIMAL_NUMBER_MESSAGE);
            }
        }
        return selectedAnimals;
    }

    private List<FloraPlant> selectPlants() {
        List<FloraPlant> selectedPlants = new ArrayList<>();
        System.out.println(ENTER_PLANT_NUMBER);

        int index = 1;
        for (FloraPlant plant : FloraPlant.values()) {
            System.out.println(index++ + ". " + plant.getPlantName());
        }

        while (true) {
            System.out.print(ENTER_PLANT_NUMBER);
            int choice = SCANNER.nextInt();
            if (choice == 0) {
                break;
            } else if (choice > 0 && choice <= FloraPlant.values().length) {
                selectedPlants.add(FloraPlant.values()[choice - 1]);
                System.out.println(FloraPlant.values()[choice - 1].getPlantName() + " добавлено.");
            } else {
                System.out.println(ERROR_ENTER_PLANT_NUMBER_MESSAGE);
            }
        }
        return selectedPlants;
    }

    @Override
    public void deleteEcosystem(String ecosystemName) {
        if (ecosystemRepository.checkEcosystemName(ecosystemName)) {
            ecosystemRepository.delete(ecosystemName);
            System.out.println("Экосистема '" + ecosystemName + "' была успешно удалена.");
        } else {
            System.out.println("Экосистема с именем '" + ecosystemName + "' не найдена.");
        }
    }

    @Override
    public void getAll() {
        List<Ecosystem> ecosystems = ecosystemRepository.getAll();
        if (ecosystems.isEmpty()) {
            System.out.println(EMPTY_LIST_ECOSYSTEM_MESSAGE);
            Utils.exit();
        } else {
            try {
                System.out.println(LIST_ECOSYSTEMS_MESSAGE);
                for (int i = 0; i < ecosystems.size(); i++) {
                    Ecosystem ecosystem = ecosystems.get(i);
                    String numberOfEcosystem = Utils.colorizeNumber(ecosystem.toString(), i + 1);
                    System.out.println(numberOfEcosystem);
                }
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }
        entryEcosystem(ecosystems);
    }

    private void entryEcosystem(List<Ecosystem> ecosystems) {
        try {
            for (int i = 0; i < Utils.ITERATION_LOOP; i++) {
                System.out.print(ENTER_ECOSYSTEM_NUMBER);
                String step = SCANNER.nextLine();
                if (step.matches(RegexConstant.STEP_REGEX)) {
                    try {
                        for (int i2 = 1; i2 <= ecosystems.size(); i2++) {
                            String currentNumber = String.valueOf(i2);
                            if (step.equals(currentNumber)) {
                                Ecosystem selectedEcosystem = ecosystems.get(i2 - 1);
                                System.out.println(SELECTED_ECOSYSTEM_MESSAGE + INDIGO + selectedEcosystem.getEcosystemName() + RESET);
                                break;
                            }
                        }
                        if (i < Utils.ITERATION_LOOP_MESSAGE) {
                            System.out.println(ERROR_ENTER_ECOSYSTEM_NUMBER_MESSAGE);
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(e.getMessage());
                    }
                } else {
                    if (i < Utils.ITERATION_LOOP_MESSAGE) {
                        System.out.println(ERROR_ENTER_MESSAGE);
                    }
                }
            }
            Utils.exitByFromAttempts();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public EcosystemServiceImpl(EcosystemRepository ecosystemRepository, AnimalService animalService, PlantService plantService) {
        this.ecosystemRepository = ecosystemRepository;
        this.animalService = animalService;
        this.plantService = plantService;
    }
}