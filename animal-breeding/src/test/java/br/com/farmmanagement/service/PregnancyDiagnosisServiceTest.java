package br.com.farmmanagement.service;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;

import br.com.farmmanagement.model.PregnancyDiagnosis;

import br.com.farmmanagement.repository.PregnancyDiagnosisRepository;

public class PregnancyDiagnosisServiceTest {

    @Mock 

    private PregnancyDiagnosisRepository repository;

    private PregnancyDiagnosisService service;

    private PregnancyDiagnosis pregnancyDiagnosis;

    @BeforeEach
    void setUp() {

    }

}
