package br.com.farmmanagement.service;

import org.h2.command.dml.MergeUsing.When;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import br.com.farmmanagement.enums.BreedingRole;
import br.com.farmmanagement.enums.BreedingStatus;
import br.com.farmmanagement.model.BreedingAnimal;
import br.com.farmmanagement.repository.BreedingAnimalRepository;

public class BreedingAnimalServiceTest {

    private BreedingAnimalService service;

    @BeforeEach
    void setUp() {
            MockitoAnnotations.openMocks(this);

            service = new BreedingAnimalService(repository);

            breedingAnimal = new BreedingAnimal(
            null, 
            4L, 
            BreedingRole.FEMALE, 
            BreedingStatus.AVAILABLE_FOR_BREEDING);
    }

    @Mock
    private BreedingAnimalRepository repository;

    private BreedingAnimal breedingAnimal;

    @Test
    void shouldSaveAnimalBreeding() {

        when(repository.save(breedingAnimal)).thenReturn(breedingAnimal);

        BreedingAnimal saved = service.save(breedingAnimal);

        assertEquals(breedingAnimal, saved);

        verify(repository).save(breedingAnimal);
    }

    @Test
    void shouldFindBreedingAnimalById() {

        Long id = 1L;

        when(repository.findById(id)).thenReturn(Optional.of(breedingAnimal));

        Optional<BreedingAnimal> result = service.findById(id);

        assertTrue(result.isPresent());

        verify(repository).findById(id);

    }
    @Test
    void shouldFindAllAnimals() {

        List<BreedingAnimal> animals = List.of(breedingAnimal);

        when(repository.findAll()).thenReturn(animals);

        List<BreedingAnimal> result = service.findAll();

        assertEquals(animals, result);
        verify(repository).findAll();
    }
    @Test
    void shouldDeleteById() {

        Long id = 1L;

        service.deleteById(id);

        verify(repository).deleteById(id);

    }


}
