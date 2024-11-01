package org.example.repository;

import org.example.model.Animal;
import org.example.model.Ecosystem;
import org.example.model.Plant;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EcosystemRepositoryImpl implements EcosystemRepository {
    private final List<Ecosystem> ecosystems = new ArrayList<>();
    private static final String DIRECTORY = "ecosystems/";

    @Override
    public void create(Ecosystem ecosystem) {
        try {
            File dir = new File(DIRECTORY);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(DIRECTORY + ecosystem.getEcosystemName() + ".txt"))) {
                writer.write(ecosystemToString(ecosystem));
                System.out.println("Экосистема сохранена: " + ecosystem.getEcosystemName());
            }
        } catch (IOException e) {
            System.err.println("Ошибка при сохранении экосистемы: " + e.getMessage());
        }
    }

    @Override
    public void delete(String name) {
        File file = new File(DIRECTORY + name + ".txt");
        if (file.exists() && file.delete()) {
            System.out.println("Экосистема удалена: " + name);
        } else {
            System.out.println("Не удалось удалить экосистему: " + name + ". Возможно, она не существует.");
        }
    }

    @Override
    public boolean checkEcosystemName(String ecosystemName) {
        File file = new File(DIRECTORY + ecosystemName + ".txt");
        return file.exists();
    }

    @Override
    public List<Ecosystem> getAll() {
        List<Ecosystem> ecosystems = new ArrayList<>();
        File dir = new File(DIRECTORY);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File[] files = dir.listFiles((d, name) -> name.endsWith(".txt"));
        if (files != null) {
            for (File file : files) {
                Ecosystem ecosystem = loadEcosystemFromFile(file.getName());
                if (ecosystem != null) {
                    ecosystems.add(ecosystem);
                }
            }
        }
        return ecosystems;
    }

    private Ecosystem loadEcosystemFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(DIRECTORY + fileName))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
            return parseEcosystem(sb.toString());
        } catch (IOException e) {
            System.err.println("Ошибка при загрузке экосистемы: " + e.getMessage());
            return null;
        }
    }

    private Ecosystem parseEcosystem(String data) {
        String[] parts = data.split("\n");
        if (parts.length < 4) {
            System.err.println("Неверный формат данных экосистемы");
            return null;
        }

        String name = parts[0];
        String temperature = parts[1];
        String humidity = parts[2];
        String waterAmount = parts[3];
        List<Animal> animals = new ArrayList<>();
        List<Plant> plants = new ArrayList<>();
        return new Ecosystem(name, temperature, humidity, waterAmount, animals, plants);
    }

    private String ecosystemToString(Ecosystem ecosystem) {
        return String.join("\n",
                ecosystem.getEcosystemName(),
                String.valueOf(ecosystem.getTemperature()),
                String.valueOf(ecosystem.getHumidity()),
                String.valueOf(ecosystem.getWaterAmount())
        );
    }
}