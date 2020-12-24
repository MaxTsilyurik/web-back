package com.example.webback.web.dto.friend;

import com.example.webback.web.dto.ParentDto;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FriendCreateDto implements ParentDto {
    UUID userId;
}
