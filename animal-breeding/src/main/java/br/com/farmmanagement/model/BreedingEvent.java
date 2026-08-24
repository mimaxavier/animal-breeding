package br.com.farmmanagement.model;

import java.time.LocalDate;

import br.com.farmmanagement.enums.MatingType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BreedingEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long femaleBreedingAnimalId;
    private Long maleBreedingAnimalId;
    private MatingType matingType;
    private LocalDate breedingDate;

    public BreedingEvent(Long id, Long femaleBreedingAnimalId, Long maleBreedingAnimalId, MatingType matingType, LocalDate breedingDate) {

        if (matingType == null) {
            throw new IllegalArgumentException("Mating Type cannot be null");
        }

        if (breedingDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Breeding date cannot be in the future");
        }


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
