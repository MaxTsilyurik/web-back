package com.example.webback.web.dto.messages;

import com.example.webback.web.dto.ParentDto;
import com.example.webback.web.dto.comment.CommentDto;
import com.example.webback.web.dto.user.UserDto;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class MessagesReadDto implements ParentDto {
    private Long id;
    private String message;
    private LocalDateTime dateTimeModif;
    private UserDto author;
    private List<CommentDto> comments;
    private Integer countLikes;
}
