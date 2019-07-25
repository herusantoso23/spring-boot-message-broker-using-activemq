package com.herusantoso.activemq.listener;

import com.google.gson.Gson;
import com.herusantoso.activemq.dto.MailDTO;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MailConsumer {

    @JmsListener(destination = "MESSAGE_QUEUE")
    public void consumer(String message){
        try {
            MailDTO mailDTO = new Gson().fromJson(message, MailDTO.class);
            System.out.println("Received message : " + mailDTO);
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
