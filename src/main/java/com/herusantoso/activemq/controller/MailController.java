package com.herusantoso.activemq.controller;

import com.google.gson.Gson;
import com.herusantoso.activemq.dto.MailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

import javax.jms.Queue;
import java.util.List;

@RestController
public class MailController {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private Queue queue;

    @PostMapping("/publish/queue")
    public String publish(@RequestBody List<MailDTO> mailDTOs) {
        mailDTOs.forEach(mailDTO -> {
            jmsTemplate.convertAndSend(queue, new Gson().toJson(mailDTO));
        });
        return "Published Successfully";
    }

}
