package br.com.farmmanagement.service;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.farmmanagement.enums.CalvingStatus;
import br.com.farmmanagement.enums.CalvingType;
import br.com.farmmanagement.model.BreedingEvent;
import br.com.farmmanagement.model.Calving;

import br.com.farmmanagement.repository.CalvingRepository;

public class CalvingServiceTest {

    private CalvingService service;

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

}
