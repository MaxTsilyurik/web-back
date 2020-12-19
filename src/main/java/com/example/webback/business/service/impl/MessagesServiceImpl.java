package com.example.webback.business.service.impl;

import com.example.webback.business.dao.MessagesRepository;
import com.example.webback.business.entity.MessagesEntity;
import com.example.webback.business.service.MessagesService;
import com.example.webback.business.service.UserService;
import com.example.webback.web.dto.messages.MessagesCreateDto;
import com.example.webback.web.dto.messages.MessagesReadDto;
import com.example.webback.web.error.ResourceNotFoundException;
import com.example.webback.web.mapper.MessagesMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MessagesServiceImpl  implements MessagesService {

    private final MessagesRepository repository;
    private final MessagesMapper messagesMapper;
    private final UserService userService;

    @Override
    public List<MessagesReadDto> findAllDto() {
        return messagesMapper.toReadDTOs(repository.findAll());
    }

    @Override
    public Long saveDto(@NotNull MessagesCreateDto dto) {
        return repository.save(messagesMapper.toEntity(dto)).getId();
    }

    @Override
    @Transactional
    public void update(@NotNull MessagesCreateDto dto) {
        MessagesEntity entity = repository.findById(dto.getId()).orElseThrow(() -> new ResourceNotFoundException(dto));
        userService.checkResolution(entity.getAuthor().getId());
        messagesMapper.updateFromDTO(dto,entity);
    }

    @Override
    public void delete(@NotNull Long id) {
        MessagesEntity entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        userService.checkResolution(entity.getAuthor().getId());
        repository.delete(entity);
    }
}
