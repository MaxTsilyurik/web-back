package com.example.webback.web.mapper;

import com.example.webback.business.entity.CommentEntity;
import com.example.webback.business.entity.MessagesEntity;
import com.example.webback.web.dto.comment.CommentCreateDto;
import com.example.webback.web.dto.comment.CommentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CommentMapper extends GenericMapper<CommentCreateDto, CommentEntity>, GenericReadMapper<CommentDto, CommentEntity> {

    @Override
    @Mapping(target = "message", source = "dto")
    CommentEntity toEntity(CommentCreateDto dto);

    default MessagesEntity toFilm(CommentCreateDto dto){
        MessagesEntity entity = new MessagesEntity();
        entity.setId(dto.getMessageId());
        return entity;
    }
}
