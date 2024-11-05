package ivanproject.controller;

import ivanproject.entity.House;
import ivanproject.service.HouseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/houses")
public class HouseController {

    private final HouseService houseService;

    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }

    @GetMapping
    public List<House> getAllHouses() {
        return houseService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<House> getHouseById(@PathVariable Long id) {
        Optional<House> house = houseService.findById(id);
        return house.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<House> createHouse(@RequestBody House house) {
        House createdHouse = houseService.save(house);
        return new ResponseEntity<>(createdHouse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<House> updateHouse(@PathVariable Long id, @RequestBody House house) {
        Optional<House> houseToUpdate = houseService.findById(id);
        if (houseToUpdate.isPresent()) {
            House existingHouse = houseToUpdate.get();
            existingHouse.setCity(house.getCity());
            existingHouse.setStreet(house.getStreet());
            existingHouse.setHouseNumber(house.getHouseNumber());
            existingHouse.setApartmentNumber(house.getApartmentNumber());
            House updatedHouse = houseService.save(existingHouse);
            return ResponseEntity.ok(updatedHouse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHouse(@PathVariable Long id) {
        houseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}