package br.com.farmmanagement.model;

import java.time.LocalDate;

import br.com.farmmanagement.enums.CalvingStatus;
import br.com.farmmanagement.enums.CalvingType;

public class Calving {
    private Long id;
    private Long pregnancyDiagnosisId;
    private CalvingType calvingType;
    private CalvingStatus calvingStatus;
    private LocalDate calvingDate;

    public Calving (
        Long id,
        Long pregnancyDiagnosisId,
        CalvingType calvingType,
        CalvingStatus calvingStatus,
        LocalDate calvingDate) {
            this.id = id;
            this.pregnancyDiagnosisId = pregnancyDiagnosisId;
            this.calvingType = calvingType;
            this.calvingStatus = calvingStatus;
            this.calvingDate = calvingDate;
    }

    public Long getId() {
        return id;
    }
    public Long getPregnancyDiagnosisId() {
        return pregnancyDiagnosisId;
    }
    public CalvingType getCalvingType() {
        return calvingType;
    }
    public CalvingStatus getCalvingStatus() {
        return calvingStatus;
    }
    public LocalDate getCalvingDate() {
        return calvingDate;
    }
}
