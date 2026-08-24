package br.com.farmmanagement.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.farmmanagement.enums.MatingType;
import br.com.farmmanagement.model.BreedingEvent;

@DataJpaTest
public class BreedingEventRepositoryTest {

    @Autowired
    private BreedingEventRepository repository;

    private BreedingEvent breedingEvent;

    @BeforeEach
    void setUp() {
        breedingEvent = new BreedingEvent(
            null, 
            4L, 5L, 
            MatingType.INSEMINATION, 
            LocalDate.of(2025, 3, 24)
        );
    }

    @Test
    void shouldSaveBreedingEvent() {
        BreedingEvent saved = repository.saveAndFlush(breedingEvent);

        assertNotNull(saved.getId());
        assertEquals(4L, saved.getFemaleBreedingAnimalId());

    }
    @Test
    void shouldFindBreedingEventById() {
        
    }

}
