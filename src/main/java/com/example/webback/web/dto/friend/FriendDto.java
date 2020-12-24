package com.example.webback.web.dto.friend;

import com.example.webback.business.enums.StatusFriends;
import com.example.webback.web.dto.ParentDto;
import com.example.webback.web.dto.user.UserDto;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FriendDto implements ParentDto {
    UserDto friend;
    StatusFriends status;
}
