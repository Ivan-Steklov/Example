package ivanproject.controller;

import ivanproject.model.ClinicResponse;
import ivanproject.service.VeterinaryClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class VeterinaryClinicController {

    private final RestTemplate restTemplate;
    private final VeterinaryClinicService veterinaryClinicService;


    @Autowired
    public VeterinaryClinicController(RestTemplate restTemplate, VeterinaryClinicService veterinaryClinicService) {
        this.restTemplate = restTemplate;
        this.veterinaryClinicService = veterinaryClinicService;
    }

    @GetMapping("/clinics")
    public List<ClinicResponse> getClinicsByTreatedAnimals(@RequestParam String treatedAnimals) {
        return veterinaryClinicService.getClinicsByTreatedAnimals(treatedAnimals);
    }
}
