package com.example.webback.business.service;

import com.example.webback.web.dto.comment.CommentCreateDto;
import com.example.webback.web.dto.comment.CommentDto;

public interface CommentService extends DtoCrudService<Long, CommentDto, CommentCreateDto> {
}
