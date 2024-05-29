package deliveroo2.consumerprototype;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    @KafkaListener(topics = "prototype-topic", groupId = "group-id-1")
    public void consume1(Order order, Acknowledgment acknowledgment) {
        System.out.println(String.format("Consumer 1: %s", order.getOrderId()));
        acknowledgment.acknowledge();
    }

    @KafkaListener(topics = "prototype-topic", groupId = "group-id-1")
    public void consume2(Order order, Acknowledgment acknowledgment) {
        System.out.println(String.format("Consumer 2: %s", order.getOrderId()));
        acknowledgment.acknowledge();
    }

    @KafkaListener(topics = "prototype-topic", groupId = "group-id-1")
    public void consume3(Order order, Acknowledgment acknowledgment) {
        System.out.println(String.format("Consumer 3: %s", order.getOrderId()));
        acknowledgment.acknowledge();
    }

}
