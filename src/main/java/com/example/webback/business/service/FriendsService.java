package com.example.webback.business.service;

import com.example.webback.web.dto.friend.FriendDto;

import java.util.List;
import java.util.UUID;

public interface FriendsService {

    void addFriend(UUID userId);

    void confirmFriend(UUID friendId);

    void deleteFriend(UUID friendId);

    List<FriendDto> getFriends();
}
