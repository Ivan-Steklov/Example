package ivanproject.service.impl;

import ivanproject.model.ClinicResponse;
import ivanproject.service.VeterinaryClinicService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VeterinaryClinicServiceImpl implements VeterinaryClinicService {

    public VeterinaryClinicServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private RestTemplate restTemplate;


    @Override
    public List<ClinicResponse> getClinicsByTreatedAnimals(String treatedAnimals) {
        String url = "http://localhost:8081/api/veterinary-clinics";

        ResponseEntity<List<ClinicResponse>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ClinicResponse>>() {}
        );

        List<ClinicResponse> clinicsResponses = response.getBody();

        if (clinicsResponses == null) {
            return List.of(); // Возвращаем пустой список, если ответ пустой
        }

        return clinicsResponses.stream()
                .filter(x -> x.getTreatedAnimals().toLowerCase()
                        .contains(treatedAnimals.toLowerCase()))
                .collect(Collectors.toList());
    }
}