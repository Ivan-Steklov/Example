package ivanproject.controller;

import io.swagger.v3.oas.annotations.Operation;
import ivanproject.entity.User;
import ivanproject.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
//@RequiredArgsConstructor // Генерирует конструктор для всех финальных полей
public class UserController {

    public UserController(UserService userService) {
        this.userService = userService;
    }

    private final UserService userService;

    @GetMapping
    @Operation(operationId = "Получение списка всех юзеров")
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping(value = "/{id}")
    @Operation(operationId = "Получение юзера по ID")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long id) {
        Optional<User> user = userService.findById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(operationId = "Создание нового юзера")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.save(user);
        return ResponseEntity.status(201).body(createdUser);
    }

    @PutMapping(value = "/{id}")
    @Operation(operationId = "Обновление юзера")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long id, @RequestBody User user) {
        user.setId(id);
        User updatedUser = userService.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping(value = "/{id}")
    @Operation(operationId = "Удаление юзера")
    public ResponseEntity<Void> deleteUser(@PathVariable(value = "id") Long id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
