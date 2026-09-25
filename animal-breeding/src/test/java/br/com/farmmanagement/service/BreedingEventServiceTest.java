package br.com.farmmanagement.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import br.com.farmmanagement.enums.MatingType;
import br.com.farmmanagement.model.BreedingEvent;
import br.com.farmmanagement.repository.BreedingEventRepository;

public class BreedingEventServiceTest {
    
    private BreedingEventService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        service = new BreedingEventService(repository);

        breedingEvent = new BreedingEvent(
            null, 
            2L, 4L, 
            MatingType.INSEMINATION, 
            LocalDate.of(2026, 3, 4));

    }

    @Mock 
    private BreedingEventRepository repository;

    private BreedingEvent breedingEvent;

    @Test 
    void shouldSaveBreedingEvent() {

        when(repository.save(breedingEvent)).thenReturn(breedingEvent);

        BreedingEvent saved = service.save(breedingEvent);

        assertEquals(breedingEvent, saved);

        verify(repository).save(breedingEvent);
    }

}
