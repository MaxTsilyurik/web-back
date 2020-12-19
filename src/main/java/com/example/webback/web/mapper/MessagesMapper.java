package com.example.webback.web.mapper;

import com.example.webback.business.entity.MessagesEntity;
import com.example.webback.web.dto.messages.MessagesCreateDto;
import com.example.webback.web.dto.messages.MessagesReadDto;
import org.mapstruct.Mapper;

@Mapper
public interface MessagesMapper extends GenericMapper<MessagesCreateDto, MessagesEntity>, GenericReadMapper<MessagesReadDto, MessagesEntity>{
}
