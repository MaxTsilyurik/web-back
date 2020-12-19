package com.example.webback.business.service.impl;

import com.example.webback.business.dao.MessagesRepository;
import com.example.webback.business.service.MessagesService;
import com.example.webback.web.dto.messages.MessagesCreateDto;
import com.example.webback.web.dto.messages.MessagesReadDto;
import com.example.webback.web.mapper.MessagesMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MessagesServiceImpl implements MessagesService {

    private final MessagesRepository repository;
    private final MessagesMapper messagesMapper;

    @Override
    public List<MessagesReadDto> findAllDto() {
        return messagesMapper.toReadDTOs(repository.findAll());
    }

    @Override
    public Long saveDto(@NotNull MessagesCreateDto dto) {
        return repository.save(messagesMapper.toEntity(dto)).getId();
    }

    @Override
    public void update(@NotNull MessagesCreateDto dto) {

    }

    @Override
    public void delete(@NotNull Long id) {

    }
}
