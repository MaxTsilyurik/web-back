package com.example.webback.web.dto.comment;

import com.example.webback.web.dto.ParentDto;
import lombok.Data;

@Data
public class CommentCreateDto implements ParentDto {
    private Long id;
    private String comment;
    private Long messageId;
}
