package br.com.farmmanagement.service;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import br.com.farmmanagement.enums.CalvingStatus;
import br.com.farmmanagement.enums.CalvingType;
import br.com.farmmanagement.model.Calving;

import br.com.farmmanagement.repository.CalvingRepository;

public class CalvingServiceTest {

    @Mock
    private CalvingRepository repository;

    private CalvingService service;

    private Calving calving;

    @BeforeEach 
    void setUp() {
        MockitoAnnotations.openMocks(this);

        service = new CalvingService(repository);

        calving = new Calving(
            null, 
            5L, 
            CalvingType.CESAREAN, 
            CalvingStatus.COMPLETED, 
            LocalDate.of(2026, 5, 1));

        }
    
        @Test
        void shouldSaveCalving() {

            when(repository.save(calving)).thenReturn(calving);

            Calving saved = service.save(calving);

            assertEquals(calving, saved);

            verify(repository).save(calving);
        }

        @Test
        void shouldFindCalvingById() {
            Long id = 1L;

            when(repository.findById(id)).thenReturn(Optional.of(calving));

            Optional<Calving> result = service.findById(id);

            assertTrue(result.isPresent());

            verify(repository).findById(id);
        }

        @Test 
        void shouldFindAllCalvings() {
            List<Calving> calvings = List.of(calving);

            when(repository.findAll()).thenReturn(calvings);

            List<Calving> result = service.findAll();

            assertEquals(calvings, result);
            verify(repository).findAll();

        }

        @Test
        void shouldDeleteById(){
            Long id = 1L;

            service.deleteById(id);

            verify(repository).deleteById(id);
            
        }

}
