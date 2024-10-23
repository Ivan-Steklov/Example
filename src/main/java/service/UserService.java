package service;

import java.util.List;

public interface UserService {
    List<String> findAll();
    String findById(Long id);
}


//package service;
//// сервисный уровень инкапсулирует бизнес-логику приложения
////import entity.User;
////import repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class UserService {
//
// //   private final UserRepository userRepository;
//
////    @Autowired
////    public UserService(UserRepository userRepository) {
////        this.userRepository = userRepository;
////    }
//
//    public List<String> findAll() {
//        List<String> list = new ArrayList<>();
//        list.add("123");
//        list.add("1234");
//        return list;
//    }

//    public Optional<User> findById(Long id) {
//        return userRepository.findById(id);
//    }
//
//    public User save(User user) {
//        return userRepository.save(user);
//    }
//
//    public void deleteById(Long id) {
//        userRepository.deleteById(id);
//    }
//}