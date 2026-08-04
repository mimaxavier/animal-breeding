package br.com.farmmanagement.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.farmmanagement.enums.BreedingRole;
import br.com.farmmanagement.enums.BreedingStatus;

public class BreedingAnimalTest {

    @Test
    void shouldCreateBreedingAnimalSuccessfully() {
        BreedingAnimal breedingAnimal = new BreedingAnimal(
            2L,
            1L,
            BreedingRole.FEMALE,
            BreedingStatus.PREGNANT
        
        );

        assertEquals(2L, breedingAnimal.getId());
        assertEquals(1L, breedingAnimal.getAnimalId());
        assertEquals(BreedingRole.FEMALE, breedingAnimal.getBreedingRole());
        assertEquals(BreedingStatus.PREGNANT, breedingAnimal.getBreedingStatus());
    }

}
