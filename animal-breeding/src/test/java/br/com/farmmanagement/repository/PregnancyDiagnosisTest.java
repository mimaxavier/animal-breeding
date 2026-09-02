package br.com.farmmanagement.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.farmmanagement.enums.MatingType;
import br.com.farmmanagement.enums.StatusPregnancy;
import br.com.farmmanagement.model.BreedingEvent;
import br.com.farmmanagement.model.PregnancyDiagnosis;

public class PregnancyDiagnosisTest {
@DataJpaTest
public class BreedingEventRepositoryTest {

    @Autowired
    private PregnancyDiagnosisRepository repository;

    private PregnancyDiagnosis pregnancyDiagnosis;

    @BeforeEach
    void setUp() {
        pregnancyDiagnosis = new PregnancyDiagnosis(
            null, 
            2L, 
            StatusPregnancy.COMPLETED, 
            LocalDate.of(2025, 7, 27));
    }

    @Test
    void shouldSavePregnancyDiagnosis() {
        PregnancyDiagnosis saved = repository.saveAndFlush(pregnancyDiagnosis);

        assertNotNull(saved.getId());
        assertEquals(2L, saved.getBreedingEventId());

    }
    @Test
    void shouldFindPregnancyDiagnosisById() {
        //A
        repository.saveAndFlush(pregnancyDiagnosis);

        //Arrange
        Optional<PregnancyDiagnosis> result = repository.findById(pregnancyDiagnosis.getId());

        //Act
        assertTrue(result.isPresent());
        assertEquals(pregnancyDiagnosis.getId(), result.get().getId());

    }

    @Test
    void shouldFindAllPregnancyDiagnosisEvent() {
        PregnancyDiagnosis event002 = new PregnancyDiagnosis(
            null, 
            3L, 
            StatusPregnancy.LOST, 
            LocalDate.of(2026, 4, 12));

        repository.saveAndFlush(pregnancyDiagnosis);
        repository.saveAndFlush(event002);

        List<PregnancyDiagnosis> result = repository.findAll();

        assertEquals(2, result.size());

    }

    @Test
    void shouldDeletePregnancyDiagnosis() {
        repository.saveAndFlush(pregnancyDiagnosis);

        repository.delete(pregnancyDiagnosis);

        Optional<PregnancyDiagnosis> result = repository.findById(pregnancyDiagnosis.getId());

        assertTrue(result.isEmpty());
    }

    @Test
    void shouldExistsById () {
        repository.saveAndFlush(pregnancyDiagnosis);

        boolean exists = repository.existsById(pregnancyDiagnosis.getId());

        assertTrue(exists);
    }

    @Test
    void shouldCountBreedingEvents() {
        PregnancyDiagnosis event002 = new PregnancyDiagnosis(
            null, 
            3L, 
            StatusPregnancy.LOST, 
            LocalDate.of(2026, 4, 12));

        repository.saveAndFlush(pregnancyDiagnosis);
        repository.saveAndFlush(event002);

        long result = repository.count();

        assertEquals(2, result);
    }

}

}
