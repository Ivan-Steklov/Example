package ivanproject.controller;

import io.swagger.v3.oas.annotations.Operation;
import ivanproject.entity.Animal;
import ivanproject.service.AnimalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping
    @Operation(operationId = "Получение списка всех животных")
    public List<Animal> getAllAnimals() {
        return animalService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(operationId = "Получение животного по ID")
    public ResponseEntity<Animal> getAnimalById(@PathVariable Long id) {
        Optional<Animal> animal = animalService.findById(id);
        return animal.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(operationId = "Создание нового животного")
    public ResponseEntity<Animal> createAnimal(@RequestBody Animal animal) {
        Animal createdAnimal = animalService.save(animal);
        return ResponseEntity.status(201).body(createdAnimal);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Animal> updateAnimal(@PathVariable Long id, @RequestBody Animal animal) {
        Optional<Animal> animalToUpdate = animalService.findById(id);
        if (animalToUpdate.isPresent()) {
            Animal existingAnimal = animalToUpdate.get();
            // Обработка потенциально null значений
            String name = animal.getName();
            if (name != null) existingAnimal.setName(name);
            Integer age = animal.getAge();
            if (age != null) existingAnimal.setAge(age);
            String type = animal.getType();
            if (type != null) existingAnimal.setType(type);

            Animal updatedAnimal = animalService.save(existingAnimal);
            return ResponseEntity.ok(updatedAnimal);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(operationId = "Удаление животного")
    public ResponseEntity<Void> deleteAnimal(@PathVariable Long id) {
        animalService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}