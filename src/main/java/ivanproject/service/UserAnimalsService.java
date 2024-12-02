package ivanproject.service;

import ivanproject.model.UserAnimalsResponse;

public interface UserAnimalsService {
    UserAnimalsResponse getUserAnimalsAndCarsById(Long userId);
}
