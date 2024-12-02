package ivanproject.model;

import java.util.List;

public class VeterinaryClinicResponse {

    private String animalType;
    private List<ClinicResponse> clinics;

    // Геттеры и сеттеры
    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public List<ClinicResponse> getClinics() {
        return clinics;
    }

    public void setClinics(List<ClinicResponse> clinics) {
        this.clinics = clinics;
    }
}
