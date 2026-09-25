package br.com.farmmanagement.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import br.com.farmmanagement.model.BreedingEvent;
import br.com.farmmanagement.repository.BreedingEventRepository;

@Service
public class BreedingEventService {

    private final BreedingEventRepository repository;

    public BreedingEventService(BreedingEventRepository repository) {
        this.repository = repository;
    }

    public BreedingEvent save(BreedingEvent breedingEvent) {
        return repository.save(breedingEvent);
    }

    public Optional<BreedingEvent> findById(Long id) {
        return repository.findById(id);
    }

    public List<BreedingEvent> findAll() {
        return repository.findAll();
    }
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
