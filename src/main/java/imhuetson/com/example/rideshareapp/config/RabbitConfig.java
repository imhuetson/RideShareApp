package imhuetson.com.example.rideshareapp.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    public static final String RIDE_QUEUE = "ride.queue";

    @Bean
    public Queue rideQueue() {
        return new Queue(RIDE_QUEUE);
    }
}
