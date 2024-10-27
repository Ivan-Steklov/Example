package ivanproject.service;

import ivanproject.entity.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    List<String> findAll(); // Возможно, это нужно изменить под ваши нужды
    Optional<User> findById(Long id);
    User save(User user);
    void deleteById(Long id);
}