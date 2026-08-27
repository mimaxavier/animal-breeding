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
        //A
        repository.saveAndFlush(breedingEvent);

        //Arrange
        Optional<BreedingEvent> result = repository.findById(breedingEvent.getId());

        //Act
        assertTrue(result.isPresent());
        assertEquals(breedingEvent.getId(), result.get().getId());

    }

    @Test
    void shouldFindAllBreedingEvents() {
        BreedingEvent event002 = new BreedingEvent(null, 3L, 4L, MatingType.INSEMINATION, LocalDate.of(2026, 4, 22));

        repository.saveAndFlush(breedingEvent);
        repository.saveAndFlush(event002);

        List<BreedingEvent> result = repository.findAll();

        assertEquals(2, result.size());

    }

    @Test
    void shouldDeleteBreedingEvent() {
        repository.saveAndFlush(breedingEvent);

        repository.delete(breedingEvent);

        Optional<BreedingEvent> result = repository.findById(breedingEvent.getId());

        assertTrue(result.isEmpty());
    }

    @Test
    void shouldExistsById () {
        repository.saveAndFlush(breedingEvent);

        boolean exists = repository.existsById(breedingEvent.getId());

        assertTrue(exists);
    }

    @Test
    void shouldCountBreedingEvents() {
        BreedingEvent event002 = new BreedingEvent(null, 3L, 4L, MatingType.INSEMINATION, LocalDate.of(2026, 4, 22));

        repository.saveAndFlush(breedingEvent);
        repository.saveAndFlush(event002);

        long result = repository.count();

        assertEquals(2, result);
    }

}
