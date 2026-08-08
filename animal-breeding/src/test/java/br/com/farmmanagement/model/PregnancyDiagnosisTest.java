package br.com.farmmanagement.model;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import br.com.farmmanagement.enums.StatusPregnancy;


public class PregnancyDiagnosisTest {

    private PregnancyDiagnosis pregnancyDiagnosis;

@BeforeEach
void setUp() {
    pregnancyDiagnosis = new PregnancyDiagnosis(
        2L,
        1L,
        StatusPregnancy.CONFIRMED,
        LocalDate.of(2026, 5, 12)
    );
}

    @Test
    void shouldCreatePregnancyDiagnosisSuccessfully() {

        assertEquals(2L, pregnancyDiagnosis.getId());
        assertEquals(1L, pregnancyDiagnosis.getBreedingEventId());
        assertEquals(StatusPregnancy.CONFIRMED, pregnancyDiagnosis.getStatusPregnancy());
        assertEquals(LocalDate.of(2026, 5, 12), pregnancyDiagnosis.getDiagnosisDate());
    }

}
