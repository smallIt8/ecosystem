package org.example.repository;

import org.example.model.Ecosystem;

import java.util.List;

public interface EcosystemRepository {

    void create(Ecosystem ecosystem);

    boolean checkEcosystemName(String ecosystemName);

    void delete(String name);

    List<Ecosystem> getAll();
}