package br.com.farmmanagement.service;

import org.springframework.stereotype.Service;

import br.com.farmmanagement.model.BreedingAnimal;
import br.com.farmmanagement.repository.BreedingAnimalRepository;

@Service
public class BreedingAnimalService {

    private final BreedingAnimalRepository repository;

    public BreedingAnimalService(BreedingAnimalRepository repository) {
        this.repository = repository;
    };

    public BreedingAnimal save(BreedingAnimal breedingAnimal) {
        return repository.save(breedingAnimal);
    }

}
