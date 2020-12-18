package com.example.webback.web.dto.comment;

import com.example.webback.web.dto.ParentDto;
import com.example.webback.web.dto.user.UserDto;
import lombok.Data;

@Data
public class CommentDto implements ParentDto {
    private Long id;
    private String comment;
    private UserDto dto;
}
