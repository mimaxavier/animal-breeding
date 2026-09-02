package br.com.farmmanagement.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.farmmanagement.enums.CalvingStatus;
import br.com.farmmanagement.enums.CalvingType;
import br.com.farmmanagement.model.Calving;

@DataJpaTest
public class CalvingRepositoryTest {

    @Autowired
    private CalvingRepository repository;

    private Calving calving;

    @BeforeEach
    void setUp() {
        calving = new Calving(
            null, 
            3L, 
            CalvingType.CESAREAN, 
            CalvingStatus.COMPLETED, 
            LocalDate.of(2026, 1, 18)
        );
    }
    @Test
    void shouldSaveCalving() {
        Calving saved = repository.saveAndFlush((calving));

        assertNotNull(saved.getId());
        assertEquals(3L, saved.getPregnancyDiagnosisId());
    }

    
    @Test
    void shouldFindCalvingById() {
        repository.saveAndFlush(calving);

        Optional<Calving> result = repository.findById(calving.getId());

        assertTrue(result.isPresent());
        assertEquals(calving.getId(), result.get().getId());


    }

    @Test
    void shouldFindAllCalvings() {
        Calving event002 = new Calving(
            null, 
            3L, 
            CalvingType.NORMAL, 
            CalvingStatus.EXPECTED, 
            LocalDate.of(2025, 3, 9));

            repository.saveAndFlush(calving);
            repository.saveAndFlush(event002);

            List<Calving> result = repository.findAll();

            assertEquals(2, result.size());
    }

    @Test
    void shouldDeleteCalving() {
        repository.saveAndFlush(calving);

        repository.delete(calving);

        Optional<Calving> result = repository.findById(calving.getId());

        assertTrue(result.isEmpty());
    }

    @Test
    void shouldExistsById() {
        repository.saveAndFlush(calving);

        boolean exists = repository.existsById(calving.getId());

        assertTrue(exists);
    }

    @Test
    void shouldCountCalvings() {
         Calving event002 = new Calving(
            null, 
            3L, 
            CalvingType.NORMAL, 
            CalvingStatus.EXPECTED, 
            LocalDate.of(2025, 3, 9));

            repository.saveAndFlush(calving);
            repository.saveAndFlush(event002);

            long result = repository.count();

            assertEquals(2, result);
    }


}
