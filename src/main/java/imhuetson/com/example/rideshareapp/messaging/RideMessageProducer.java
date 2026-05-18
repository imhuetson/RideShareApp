package imhuetson.com.example.rideshareapp.messaging;

import imhuetson.com.example.rideshareapp.config.RabbitConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class RideMessageProducer {
    private final RabbitTemplate rabbitTemplate;

    public RideMessageProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend(RabbitConfig.RIDE_QUEUE, message);
    }
}
