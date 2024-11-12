package ivanproject.service;

import ivanproject.entity.Cars;
import ivanproject.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Cars> findAll() {
        return carRepository.findAll();
    }

    public Optional<Cars> findById(Long id) {
        return carRepository.findById(id);
    }

    public Cars save(Cars car) {
        return carRepository.save(car);
    }

    public void deleteById(Long id) {
        carRepository.deleteById(id);
    }
}
