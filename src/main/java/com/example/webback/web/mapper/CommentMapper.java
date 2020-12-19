package com.example.webback.web.mapper;

import com.example.webback.business.entity.CommentEntity;
import com.example.webback.web.dto.comment.CommentCreateDto;
import com.example.webback.web.dto.comment.CommentDto;
import org.mapstruct.Mapper;

@Mapper
public interface CommentMapper extends GenericMapper<CommentCreateDto, CommentEntity>, GenericReadMapper<CommentDto, CommentEntity> {
}
