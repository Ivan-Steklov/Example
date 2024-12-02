package ivanproject.service.impl;

import ivanproject.model.CarServiceResponse;
import ivanproject.service.CarServiceService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceServiceImpl implements CarServiceService {

    private final RestTemplate restTemplate;

    public CarServiceServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<CarServiceResponse> getCarServicesByBrand(String brand) {
        String url = "http://localhost:8081/api/car-services";

        ResponseEntity<List<CarServiceResponse>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<CarServiceResponse>>() {}
        );

        List<CarServiceResponse> carServiceResponses = response.getBody();

        if (carServiceResponses == null) {
            return List.of(); // Возвращаем пустой список, если ответ пустой
        }

        return carServiceResponses.stream()
                .filter(x -> x.getBrandServiced() != null && x.getBrandServiced().toLowerCase()
                        .contains(brand.toLowerCase()))
                .collect(Collectors.toList());
    }
}

