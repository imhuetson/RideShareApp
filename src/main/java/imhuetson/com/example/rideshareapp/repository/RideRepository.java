package imhuetson.com.example.rideshareapp.repository;

import imhuetson.com.example.rideshareapp.domain.Ride;
import org.springframework.data.repository.CrudRepository;

public interface RideRepository extends CrudRepository<Ride, Long> {
}
