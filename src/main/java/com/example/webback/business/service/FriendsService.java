package com.example.webback.business.service;

import java.util.UUID;

public interface FriendsService {

    void addFriend(UUID userId);

    void confirmFriend(UUID friendId);

    void deleteFriend(UUID friendId);
}
