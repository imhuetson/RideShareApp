package imhuetsoninventoryapp.com.example.rideshareapp.repository;

import imhuetsoninventoryapp.com.example.rideshareapp.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface RideRepository extends CrudRepository<User, Long> {
}
