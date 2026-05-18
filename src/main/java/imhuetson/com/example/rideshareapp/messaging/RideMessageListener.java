package imhuetson.com.example.rideshareapp.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RideMessageListener {
    @RabbitListener(queues="ride.queue")
    public void receiveMessage(String message) {
        System.out.println("Ride Message Received: " + message);
    }
}
