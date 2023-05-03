package com.test.springdemo.services;

import com.test.springdemo.dto.Message;
import com.test.springdemo.publisher.Publisher;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    Publisher publisher;

    public TestService(Publisher publisher) {
        this.publisher = publisher;
    }

    public void sendToRabbit(Message message){
        System.out.println("Message to send = " + message);
        publisher.send(message);
    }
}
