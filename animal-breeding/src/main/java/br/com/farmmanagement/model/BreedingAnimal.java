package br.com.farmmanagement.model;

import br.com.farmmanagement.enums.BreedingStatus;
import br.com.farmmanagement.enums.BreedingRole;

public class BreedingAnimal {
    private Long id;
    private Long animalId;
    private BreedingRole breedingRole;
    private BreedingStatus breedingStatus;


    public BreedingAnimal(Long id, Long animalId, BreedingRole breedingRole, BreedingStatus breedingStatus) {
        this.id = id;
        this.animalId = animalId;
        this.breedingRole = breedingRole;
        this.breedingStatus = breedingStatus;
    }

    public Long getId() {
        return id;
    }

    public Long getAnimalId() {
        return animalId;
    }

    public BreedingRole getBreedingRole() {
        return breedingRole;
    }

    public BreedingStatus getBreedingStatus() {
        return breedingStatus;
    }

}