package com.example.webback.web.dto.messages;

import com.example.webback.web.dto.ParentDto;
import lombok.Data;

@Data
public class MessagesCreateDto implements ParentDto {
    private Long id;
    private String message;
}
