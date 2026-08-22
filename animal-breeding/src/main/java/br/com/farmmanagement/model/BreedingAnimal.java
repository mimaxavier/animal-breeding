package br.com.farmmanagement.model;

import br.com.farmmanagement.enums.BreedingStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import br.com.farmmanagement.enums.BreedingRole;

@Entity
public class BreedingAnimal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long animalId;
    private BreedingRole breedingRole;
    private BreedingStatus breedingStatus;


    public BreedingAnimal(Long id, Long animalId, BreedingRole breedingRole, BreedingStatus breedingStatus) {

        if (animalId == null) {
            throw new IllegalArgumentException("Animal ID cannot be null");
        }
        if (animalId <= 0) {
            throw new IllegalArgumentException("Animal ID must be greater than 0");
        }
        if (breedingRole == null) {
            throw new IllegalArgumentException("Breeding role cannot be null");
        }
        if (breedingStatus == null) {
            throw new IllegalArgumentException("Status cannot be null");
        }

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

    // setters

    // métodos da entidade

    @Override
    public String toString() {
        return "BreedingAnimal{" +
            "id=" + id +
            ", animalId=" + animalId +
            ", breedingRole=" + breedingRole +
            ", breedingStatus=" + breedingStatus +
            '}';
    }


}