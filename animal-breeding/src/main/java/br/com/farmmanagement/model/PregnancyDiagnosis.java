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
            if (breedingEventId == null) {
                throw new IllegalArgumentException("Breeding Event ID cannot be null");
            }

            if (breedingEventId <= 0) {
                throw new IllegalArgumentException("BreedingEvent ID cannot be less than 0");
            }

            if (diagnosisDate.isAfter(LocalDate.now())) {
                throw new IllegalArgumentException("Date cannot be in the future");
            }
        
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
