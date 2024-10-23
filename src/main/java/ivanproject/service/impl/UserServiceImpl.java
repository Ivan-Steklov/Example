package ivanproject.service.impl;

import ivanproject.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Data
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Override
    public List<String> findAll() {
        // Пример данных
        return Arrays.asList("User1", "User2", "User3", "User4");
    }

    @Override
    public String findById(Long id) {
        // Пример данных
        return "User" + id;
    }
}
