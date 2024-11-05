package ivanproject.controller;

import io.swagger.v3.oas.annotations.Operation;
import ivanproject.entity.Animal;
import ivanproject.service.AnimalService;
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
    @Operation(operationId = "Обновление животного")
    public ResponseEntity<Animal> updateAnimal(@PathVariable Long id, @RequestBody Animal animal) {
        animal.setId(id); //  Рассмотрите альтернативный подход, как в предыдущем ответе
        Animal updatedAnimal = animalService.save(animal);
        return ResponseEntity.ok(updatedAnimal);
    }

    @DeleteMapping("/{id}")
    @Operation(operationId = "Удаление животного")
    public ResponseEntity<Void> deleteAnimal(@PathVariable Long id) {
        animalService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
