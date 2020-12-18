package com.example.webback.business.service.impl;

import com.example.webback.business.service.MessagesService;
import com.example.webback.web.dto.messages.MessagesCreateDto;
import com.example.webback.web.dto.messages.MessagesReadDto;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class MessagesServiceImp implements MessagesService {

    @Override
    public List<MessagesReadDto> findAllDto() {
        return null;
    }

    @Override
    public Long saveDto(@NotNull MessagesCreateDto dto) {
        return null;
    }

    @Override
    public void update(@NotNull MessagesCreateDto dto) {

    }

    @Override
    public void delete(@NotNull Long id) {

    }
}
