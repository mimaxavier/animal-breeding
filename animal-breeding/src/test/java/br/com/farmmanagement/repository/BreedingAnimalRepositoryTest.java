package br.com.farmmanagement.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.farmmanagement.enums.BreedingRole;
import br.com.farmmanagement.enums.BreedingStatus;
import br.com.farmmanagement.model.BreedingAnimal;

@DataJpaTest
public class BreedingAnimalRepositoryTest {

    @Autowired
    private BreedingAnimalRepository repository;

    @Test
    void shouldSaveBreedingAnimal() {
        BreedingAnimal breedingAnimal = new BreedingAnimal(
            null, 
            5L, 
            BreedingRole.FEMALE, 
            BreedingStatus.INAVAILABLE_FOR_BREEDING);

        BreedingAnimal saved = repository.saveAndFlush(breedingAnimal);

        assertNotNull(saved.getId());
        assertEquals(5L, saved.getAnimalId());
    }

}
