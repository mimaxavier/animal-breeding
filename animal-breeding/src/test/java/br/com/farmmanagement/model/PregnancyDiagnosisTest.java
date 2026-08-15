package br.com.farmmanagement.model;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import br.com.farmmanagement.enums.StatusPregnancy;


public class PregnancyDiagnosisTest {

    @Test
    void shouldCreatePregnancyDiagnosisSuccessfully() {

        PregnancyDiagnosis pregnancyDiagnosis = new PregnancyDiagnosis(
            3L, 
            3L, 
            StatusPregnancy.CONFIRMED, 
            LocalDate.of(2026, 5, 12)
        );

        assertEquals(3L, pregnancyDiagnosis.getId());
        assertEquals(3L, pregnancyDiagnosis.getBreedingEventId());
        assertEquals(StatusPregnancy.CONFIRMED, pregnancyDiagnosis.getStatusPregnancy());
        assertEquals(LocalDate.of(2026, 5, 12), pregnancyDiagnosis.getDiagnosisDate());
    }
    @Test
    void shouldBreedingEventIdCannotBeNull () {
           assertThrows(
            IllegalArgumentException.class, 
            () -> new PregnancyDiagnosis(
                3L, 
                null, 
                StatusPregnancy.CONFIRMED, 
                LocalDate.of(2026, 5, 12)
            )
        );
    }

    @Test
    void shouldBreedingEventIdmustbegreaterthanzero() {

        assertThrows(
            IllegalArgumentException.class, 
            () -> new PregnancyDiagnosis(
                3L, 
                0L, 
                StatusPregnancy.CONFIRMED, 
                LocalDate.of(2026, 5, 12)
            )
        );

    }
    @Test
    void shouldDiagnosisDateCannotBeInTheFuture() {
        assertThrows(
            IllegalArgumentException.class, () -> new PregnancyDiagnosis(
                3L, 
                2L, 
                StatusPregnancy.CONFIRMED, 
                LocalDate.of(2026, 11, 12)
            )
        );
    }

}
