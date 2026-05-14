package imhuetsoninventoryapp.com.example.rideshareapp.repository;

import imhuetsoninventoryapp.com.example.rideshareapp.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
