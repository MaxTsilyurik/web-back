package com.example.webback.web.api.v1;

import com.example.webback.business.entity.MessagesEntity;
import com.example.webback.business.service.MessagesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessagesController {

    private final MessagesService messagesService;

    public MessagesController(MessagesService messagesService) {
        this.messagesService = messagesService;
    }

    @GetMapping
    List<MessagesEntity> getAllMessages(){
        return messagesService.getAll();
    }
}
