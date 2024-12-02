package ivanproject.service;

import ivanproject.model.CarServiceResponse;

import java.util.List;

public interface CarServiceService {
    List<CarServiceResponse> getCarServicesByBrand(String brand);
}
