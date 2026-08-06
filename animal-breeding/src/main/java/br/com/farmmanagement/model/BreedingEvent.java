package br.com.farmmanagement.model;

import java.time.LocalDate;

import br.com.farmmanagement.enums.MatingType;

public class BreedingEvent {
    private Long id;
    private Long femaleBreedingAnimalId;
    private Long maleBreedingAnimalId;
    private MatingType matingType;
    private LocalDate breedingDate;

    public BreedingEvent(Long id, Long femaleBreedingAnimalId, Long maleBreedingAnimalId, MatingType matingType, LocalDate breedingDate) {
        this.id = id;
        this.femaleBreedingAnimalId = femaleBreedingAnimalId;
        this.maleBreedingAnimalId = maleBreedingAnimalId;
        this.matingType = matingType;
        this.breedingDate = breedingDate;
    }

    public Long getId() {
        return id;
    }

    public Long getFemaleBreedingAnimalId() {
        return femaleBreedingAnimalId;
    }

    public Long getMaleBreedingAnimalId() {
        return maleBreedingAnimalId;
    }

    public MatingType getMatingType() {
        return matingType;
    }

    public LocalDate getBreedingDate() {
        return breedingDate;
    }

}
