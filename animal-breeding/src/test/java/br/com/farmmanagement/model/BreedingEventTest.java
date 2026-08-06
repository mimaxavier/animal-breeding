package br.com.farmmanagement.model;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import br.com.farmmanagement.enums.MatingType;

public class BreedingEventTest {
    
    @Test
    void shouldCreateBreedingEventSuccessfully() {
        BreedingEvent breedingEvent = new BreedingEvent(
            2L, 
            1L, 
            4L, 
            MatingType.NATURAL_COVER, 
            LocalDate.of(2025, 3, 12)
        );
        assertEquals(2L, breedingEvent.getId());
        assertEquals(1L, breedingEvent.getFemaleBreedingAnimalId());
        assertEquals(4L, breedingEvent.getMaleBreedingAnimalId());
        assertEquals(MatingType.NATURAL_COVER, breedingEvent.getMatingType());
        assertEquals(LocalDate.of(2025, 3, 12), breedingEvent.getBreedingDate());

    }
}
