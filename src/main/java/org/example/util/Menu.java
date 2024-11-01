package org.example.util;

import org.example.contriller.PersonController;
import org.example.repository.*;
import org.example.service.*;

public class Menu {
    public static void start() {
        EcosystemRepository ecosystemRepository = new EcosystemRepositoryImpl();
        AnimalRepository animalRepository = new AnimalRepositoryImpl();
        PlantRepository plantRepository = new PlantRepositoryImpl();
        PlantService plantService = new PlantServiceImpl(plantRepository);
        AnimalService animalService = new AnimalServiceImpl(animalRepository, plantService);
        EcosystemService ecosystemService = new EcosystemServiceImpl(ecosystemRepository, animalService, plantService);
        PersonController personController = new PersonController(ecosystemService);
        personController.welcomePerson();
    }

    public Menu() {
    }
}