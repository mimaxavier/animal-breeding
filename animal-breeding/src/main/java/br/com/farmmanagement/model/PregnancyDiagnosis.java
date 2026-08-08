package br.com.farmmanagement.model;

import java.time.LocalDate;

import br.com.farmmanagement.enums.StatusPregnancy;

public class PregnancyDiagnosis {
    private Long id;
    private Long breedingEventId;
    private StatusPregnancy statusPregnancy;
    private LocalDate diagnosisDate;

    public PregnancyDiagnosis(
        Long id, 
        Long breedingEventId, 
        StatusPregnancy statusPregnancy, 
        LocalDate diagnosisDate) {
            this.id = id;
            this.breedingEventId = breedingEventId;
            this.statusPregnancy = statusPregnancy;
            this.diagnosisDate = diagnosisDate;
    }

    public Long getId() {
        return id;
    }

    public Long getBreedingEventId() {
        return breedingEventId;
    }
    
    public StatusPregnancy getStatusPregnancy() {
        return statusPregnancy;
    }

    public LocalDate getDiagnosisDate() {
        return diagnosisDate;
    }

}
