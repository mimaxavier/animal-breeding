package br.com.farmmanagement.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
            BreedingStatus.AVAILABLE_FOR_BREEDING
        
        );

        assertEquals(2L, breedingAnimal.getId());
        assertEquals(1L, breedingAnimal.getAnimalId());
        assertEquals(BreedingRole.FEMALE, breedingAnimal.getBreedingRole());
        assertEquals(BreedingStatus.AVAILABLE_FOR_BREEDING, breedingAnimal.getBreedingStatus());
    }

    @Test
    void shouldThrowExceptionWhenAnimalIdisNull() {

        assertThrows(
            IllegalArgumentException.class, 
        () -> new BreedingAnimal(
            1L, 
            null, 
            BreedingRole.FEMALE, 
            BreedingStatus.AVAILABLE_FOR_BREEDING)
        
    );
    
    }

    @Test
    void shouldThrowExceptionWhenAnimalislessThanOrEqualToZero() {
        assertThrows(IllegalArgumentException.class, () -> new BreedingAnimal(
            1L, 
            -4L, 
            BreedingRole.FEMALE, 
            BreedingStatus.AVAILABLE_FOR_BREEDING)   
    );


    }

    @Test
    void shouldThrowExceptionWhenBreedingRoleisnull() {

        assertThrows(IllegalArgumentException.class, 
            () -> new BreedingAnimal(
                1L, 
                3L, 
                null, 
                BreedingStatus.AVAILABLE_FOR_BREEDING)          
            );
    }
    @Test
    void shouldThrowExceptionWhenBreedingStatusIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new BreedingAnimal(
            1L, 
            3L, BreedingRole.FEMALE, null)  
        );
    }

}
