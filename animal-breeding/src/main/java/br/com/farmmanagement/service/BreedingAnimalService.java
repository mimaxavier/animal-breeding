package br.com.farmmanagement.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import br.com.farmmanagement.model.BreedingAnimal;
import br.com.farmmanagement.repository.BreedingAnimalRepository;

@Service
public class BreedingAnimalService {

    private final BreedingAnimalRepository repository;

    public BreedingAnimalService(BreedingAnimalRepository repository) {
        this.repository = repository;
    }

    public BreedingAnimal save(BreedingAnimal breedingAnimal) {
        return repository.save(breedingAnimal);
    }

    public Optional<BreedingAnimal> findById(Long id) {
        return repository.findById(id);
    }

    public List<BreedingAnimal> findAll() {
        return repository.findAll();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
