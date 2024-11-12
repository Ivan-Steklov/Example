package ivanproject.controller;
import ivanproject.entity.Cars;
import ivanproject.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<Cars> getAllCars() {
        return carService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cars> getCarById(@PathVariable Long id) {
        Optional<Cars> car = carService.findById(id);
        return car.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Cars> createCar(@RequestBody Cars car) {
        Cars createdCar = carService.save(car);
        return new ResponseEntity<>(createdCar, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cars> updateCar(@PathVariable Long id, @RequestBody Cars car) {
        // НЕ УСТАНАВЛИВАЙТЕ ID РУЧНО!
        Optional<Cars> carToUpdate = carService.findById(id);
        if (carToUpdate.isPresent()) {
            Cars existingCar = carToUpdate.get();
            existingCar.setBrand(car.getBrand());
            existingCar.setModel(car.getModel());
            existingCar.setYear(car.getYear());
            Cars updatedCar = carService.save(existingCar);
            return ResponseEntity.ok(updatedCar);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        carService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}