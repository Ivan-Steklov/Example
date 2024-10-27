package ivanproject.repository;
//Репозиторий отвечает за доступ к данным, взаимодействуя с базой данных.
import ivanproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}