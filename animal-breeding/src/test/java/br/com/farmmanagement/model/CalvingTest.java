package br.com.farmmanagement.model;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.farmmanagement.enums.CalvingStatus;
import br.com.farmmanagement.enums.CalvingType;

public class CalvingTest {
    
    private Calving calving;

@BeforeEach
void setUp() {
    calving = new Calving(
        2L, 
        1L,
        CalvingType.NORMAL,
        CalvingStatus.COMPLETED,
        LocalDate.of(2025, 4, 20)
    );
}

    @Test
    void shouldCreateCalvingSuccessfully() {
        assertEquals(2L, calving.getId());
        assertEquals(1L, calving.getPregnancyDiagnosisId());
        assertEquals(CalvingType.NORMAL, calving.getCalvingType());
        assertEquals(CalvingStatus.COMPLETED, calving.getCalvingStatus());
        assertEquals(LocalDate.of(2025, 4, 20), calving.getCalvingDate());
    }

}
