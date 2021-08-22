package com.kavindu.activemqdemo.controller;

import com.kavindu.activemqdemo.dto.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    @Autowired
    JmsTemplate jmsTemplate;

    @GetMapping("/{name}")
    public ResponseEntity test(@PathVariable String name) {
        return new ResponseEntity("hello "+name,HttpStatus.ACCEPTED);
    }

    @PostMapping("/send")
    public ResponseEntity test(@RequestBody Email email) {
        jmsTemplate.convertAndSend("mailbox", email);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
