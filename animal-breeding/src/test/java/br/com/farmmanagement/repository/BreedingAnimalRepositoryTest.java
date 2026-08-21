package br.com.farmmanagement.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import br.com.farmmanagement.enums.BreedingRole;
import br.com.farmmanagement.enums.BreedingStatus;
import br.com.farmmanagement.model.BreedingAnimal;

@DataJpaTest
public class BreedingAnimalRepositoryTest {

    @Autowired
    private BreedingAnimalRepository repository;

    private BreedingAnimal breedingAnimal;

    @BeforeEach
    void setUp() {
        breedingAnimal = new BreedingAnimal(
            null, 
            5L, 
            BreedingRole.FEMALE, 
            BreedingStatus.INAVAILABLE_FOR_BREEDING
    );
    }

    @Test
    void shouldSaveBreedingAnimal() {
        BreedingAnimal saved = repository.saveAndFlush(breedingAnimal);

        assertNotNull(saved.getId());
        assertEquals(5L, saved.getAnimalId());

    }
    @Test
    void shouldFindBreedingAnimalById() {
        BreedingAnimal saved = repository.saveAndFlush(breedingAnimal);

       Optional<BreedingAnimal> result = repository.findById(saved.getId());

       BreedingAnimal found = result.get();

        assertTrue(result.isPresent());
        assertEquals(saved.getId(), found.getId());
        assertEquals(saved.getAnimalId(), found.getAnimalId());
    }

    @Test
    void shouldFindAllBreedingAnimal() {

    }

}
