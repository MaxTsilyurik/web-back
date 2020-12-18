package com.example.webback.web.dto.friend;

import com.example.webback.web.dto.ParentDto;
import com.example.webback.web.dto.user.UserDto;
import lombok.Data;

import java.util.List;

@Data
public class FriendReadDto implements ParentDto {
    private List<UserDto> friend;
}
