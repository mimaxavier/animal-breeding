package br.com.farmmanagement.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import br.com.farmmanagement.model.Calving;
import br.com.farmmanagement.repository.CalvingRepository;

@Service 
public class CalvingService {

    private final CalvingRepository repository;

    public CalvingService(CalvingRepository repository) {
        this.repository = repository;
    }

    public Calving save(Calving calving) {
        return repository.save(calving);
    }

    public Optional<Calving> findById(Long id) {
        return repository.findById(id);
    }

    public List<Calving> findAll() {
        return repository.findAll();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
