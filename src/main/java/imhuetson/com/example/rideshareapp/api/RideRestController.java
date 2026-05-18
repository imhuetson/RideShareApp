package imhuetson.com.example.rideshareapp.api;

import imhuetson.com.example.rideshareapp.domain.Ride;
import imhuetson.com.example.rideshareapp.dto.RideDTO;
import imhuetson.com.example.rideshareapp.repository.RideRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/rides")
public class RideRestController {
    private final RideRepository rideRepo;

    public RideRestController(RideRepository rideRepo) {
        this.rideRepo = rideRepo;
    }

    @GetMapping
    public List<RideDTO> getAllRides() {
        List<RideDTO> rides = new ArrayList<>();

        for(Ride ride : rideRepo.findAll()) {
            RideDTO dto = convertToDTO(ride);
            rides.add(dto);
        }
        return rides;
    }

    @GetMapping("/{id}")
    public RideDTO getRide(@PathVariable Long id) {
        Ride ride = rideRepo.findById(id).orElse(null);

        if(ride == null) {
            return null;
        }
        return convertToDTO(ride);
    }

    @PostMapping
    public Ride createRide(@RequestBody Ride ride) {
        return rideRepo.save(ride);
    }

    @PutMapping("/{id}")
    public Ride updateRide(@PathVariable Long id, @RequestBody Ride updatedRide) {
        Ride ride = rideRepo.findById(id).orElse(null);

        if(ride == null) {
            return null;
        }

        ride.setFromLocation(updatedRide.getFromLocation());
        ride.setToCampus(updatedRide.getToCampus());
        ride.setDepartureTime(updatedRide.getDepartureTime());
        ride.setArrivalTime(updatedRide.getArrivalTime());
        ride.setMaxPassengers(updatedRide.getMaxPassengers());
        return rideRepo.save(ride);
    }

    @DeleteMapping("/{id}")
    public void deleteRide(@PathVariable Long id) {
        rideRepo.deleteById(id);
    }

    private RideDTO convertToDTO(Ride ride) {
        RideDTO dto = new RideDTO();
        dto.setId(ride.getId());
        dto.setFromLocation(ride.getFromLocation());
        dto.setToCampus(ride.getToCampus());
        dto.setDepartureTime(ride.getDepartureTime());
        dto.setArrivalTime(ride.getArrivalTime());
        dto.setMaxPassengers(ride.getMaxPassengers());
        dto.setCurrentPassengers(ride.getPassengers().size());
        dto.setCancelled(ride.isCancelled());
        return dto;
    }
}
