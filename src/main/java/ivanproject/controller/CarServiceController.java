package ivanproject.controller;

import ivanproject.model.CarServiceResponse;
import ivanproject.service.CarServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class CarServiceController {

    private final RestTemplate restTemplate;
    private final CarServiceService carServiceService;

    @Autowired
    public CarServiceController(RestTemplate restTemplate, CarServiceService carServiceService) {
        this.restTemplate = restTemplate;
        this.carServiceService = carServiceService;
    }

    @GetMapping("/car-services")
    public List<CarServiceResponse> getCarServicesByBrand(@RequestParam String brand) {
        return carServiceService.getCarServicesByBrand(brand);
    }
}
