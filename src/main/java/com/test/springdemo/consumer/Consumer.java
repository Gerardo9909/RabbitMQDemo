package com.test.springdemo.consumer;

import com.test.springdemo.dto.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @RabbitListener(queues = {"${test.queue.name}"})
    public void receive(final Message message) {
        //com.test.springdemo.dto.Message message1 = (com.test.springdemo.dto.Message) SerializationUtils.deserialize(message.getBody());
        System.out.println("Received message = " + message);
        makeSlow();

    }

    public void makeSlow() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
