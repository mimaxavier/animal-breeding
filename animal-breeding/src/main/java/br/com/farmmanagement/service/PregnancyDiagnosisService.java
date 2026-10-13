package br.com.farmmanagement.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import br.com.farmmanagement.model.PregnancyDiagnosis;
import br.com.farmmanagement.repository.PregnancyDiagnosisRepository;

@Service

public class PregnancyDiagnosisService {

    private final PregnancyDiagnosisRepository repository;

    public PregnancyDiagnosisService(PregnancyDiagnosisRepository repository) {
        this.repository = repository;
    }

    public PregnancyDiagnosis save(PregnancyDiagnosis pregnancyDiagnosis) {
        return repository.save(pregnancyDiagnosis);
    }

    public Optional<PregnancyDiagnosis> findById(Long id) {
        return  repository.findById(id);
    }

    public List<PregnancyDiagnosis> findAll() {
        return repository.findAll();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
