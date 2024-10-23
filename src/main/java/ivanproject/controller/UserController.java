package ivanproject.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ivanproject.service.impl.UserServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;


    @GetMapping
    @Operation(operationId = "Получение списка всех юзеров")
    public List<String> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping(value ="/{id}")
    @Operation(operationId = "Получение юзера")
    public String getUserById(@PathVariable Long id) {
        return userService.findById(id);
    }


    //    @GetMapping("/{id}")
//    public ResponseEntity<User> getUserById(@PathVariable Long id) {
//        Optional<User> user = userService.findById(id);
//        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @PostMapping
//    public User createUser(@RequestBody User user) {
//        return userService.save(user);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
//        return userService.findById(id)
//                .map(user -> {
//                    user.setFirstName(userDetails.getFirstName());
//                    user.setLastName(userDetails.getLastName());
//                    user.setMiddleName(userDetails.getMiddleName());
//                    user.setBirthDate(userDetails.getBirthDate());
//                    user.setBalance(userDetails.getBalance());
//                    return ResponseEntity.ok(userService.save(user));
//                })
//                .orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
//        Optional<User> userOptional = userService.findById(id);
//
//        if (userOptional.isPresent()) {
//            userService.deleteById(id); // Удаление пользователя
//            return ResponseEntity.ok().build(); // Возвращаем статус 200 OK
//        } else {
//            return ResponseEntity.notFound().build(); // Возвращаем статус 404 NOT FOUND
//        }
//    }

}
