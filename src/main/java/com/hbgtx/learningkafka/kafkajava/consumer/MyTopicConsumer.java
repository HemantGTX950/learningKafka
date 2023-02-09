package com.hbgtx.learningkafka.kafkajava.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.hbgtx.learningkafka.kafkajava.util.ConstantUtils.GROUP_ID;
import static com.hbgtx.learningkafka.kafkajava.util.ConstantUtils.TOPIC_NAME;

@Component
public class MyTopicConsumer {

    private final List<String> messages = new ArrayList<>();

    @KafkaListener(topics = TOPIC_NAME, groupId = GROUP_ID)
    public void listen(String message) {
        synchronized (messages) {
            System.out.println("Received message:" + message);
            messages.add(message);
        }
    }

    public List<String> getMessages() {
        return messages;
    }
}
