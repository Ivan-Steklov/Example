package ivanproject.service;

import java.util.List;

public interface UserService {

    List<String> findAll();

    String findById(Long id);
}
