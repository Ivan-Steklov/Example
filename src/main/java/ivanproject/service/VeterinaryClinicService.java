package ivanproject.service;

import ivanproject.model.ClinicResponse;

import java.util.List;

public interface VeterinaryClinicService {
    List<ClinicResponse> getClinicsByTreatedAnimals(String treatedAnimals);
}