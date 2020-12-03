package com.example.webback.business.service.impl;

import com.example.webback.business.entity.MessagesEntity;
import com.example.webback.business.entity.UserEntity;
import com.example.webback.business.service.MessagesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessagesServiceImp implements MessagesService {

    private List<MessagesEntity> init() {
        UserEntity userEntity = new UserEntity(1L, "Max", "Tsilyurik");
        UserEntity userEntity2 = new UserEntity(2L, "Petr", "Ivanov");
        UserEntity userEntity3 = new UserEntity(3L, "Ricardo", "Milos");

        MessagesEntity messagesEntity = new MessagesEntity(1L, "Бэк это прекрасно", userEntity);
        MessagesEntity messagesEntity2 = new MessagesEntity(2L, "Я с ним согласен", userEntity2);
        MessagesEntity messagesEntity3 = new MessagesEntity(3L, "Космический флекс", userEntity3);
        return List.of(messagesEntity, messagesEntity2, messagesEntity3);
    }

    @Override
    public List<MessagesEntity> getAll() {
        return init();
    }
}
