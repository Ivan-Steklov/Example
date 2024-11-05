package ivanproject.service;

import ivanproject.entity.Animal;
import java.util.List;
import java.util.Optional; // Не забудьте добавить этот импорт!

public interface AnimalService {
    List<Animal> findAll(); // Исправлено: теперь возвращает List<Animal>
    Optional<Animal> findById(Long id); // Добавлен метод findById
    Animal save(Animal animal);
    void deleteById(Long id);
}
