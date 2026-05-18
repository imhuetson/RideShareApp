package imhuetson.com.example.rideshareapp.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class RideDTO {
    @Setter
    @Getter
    private Long id;
    @Getter
    @Setter
    private String fromLocation;
    @Getter
    @Setter
    private String toCampus;
    @Getter
    @Setter
    private LocalDateTime departureTime;
    @Getter
    @Setter
    private LocalDateTime arrivalTime;
    @Getter
    @Setter
    private int maxPassengers;
    @Getter
    @Setter
    private int currentPassengers;
    @Getter
    @Setter
    private boolean cancelled;
    public RideDTO() {}
}
