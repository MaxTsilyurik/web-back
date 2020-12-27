package com.example.webback.business.service.impl;

import com.example.webback.business.dao.FriendsRepository;
import com.example.webback.business.entity.FriendEntity;
import com.example.webback.business.entity.UserEntity;
import com.example.webback.business.enums.StatusFriends;
import com.example.webback.business.service.FriendsService;
import com.example.webback.business.service.UserService;
import com.example.webback.web.dto.friend.FriendDto;
import com.example.webback.web.dto.friend.FriendReadDto;
import com.example.webback.web.error.ResourceNotFoundException;
import com.example.webback.web.mapper.FriendsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

import static com.example.webback.business.enums.StatusFriends.*;

@Service
@RequiredArgsConstructor
public class FriendsServiceImpl implements FriendsService {
    private final FriendsRepository repository;
    private final UserService userService;
    private final FriendsMapper mapper;


    private void addedFriend(UserEntity entity, UserEntity friend, StatusFriends statusFriends){
        entity.setFriends(List.of(
                FriendEntity
                        .builder()
                        .friend(friend)
                        .user(entity)
                        .status(statusFriends)
                        .build())
        );
    }

    private UUID getUserId(){
        String id = userService.getAdditionInformation((OAuth2Authentication)
                SecurityContextHolder
                        .getContext()
                        .getAuthentication()
        ).get("user_id").toString();
        return UUID.fromString(id);
    }

    @Override
    public void addFriend(UUID userId) {

        UserEntity user = userService.findById(getUserId());
        UserEntity friend = userService.findById(userId);
        addedFriend(user,friend,EXPECTATION);
        addedFriend(friend,user,REQUEST);
        userService.save(user);
        userService.save(friend);
    }

    @Override
    @Transactional
    public void confirmFriend(UUID friendId) {
        if (!repository.existsByFriendId(friendId))
            throw new ResourceNotFoundException(friendId);
        FriendEntity friendEntity = repository.findByFriendId(friendId);
        FriendEntity user = repository.findByFriendId(getUserId());
        friendEntity.setStatus(StatusFriends.FRIEND);
        user.setStatus(FRIEND);
    }

    @Override
    public void deleteFriend(UUID friendId) {
        if (!repository.existsByFriendId(friendId))
            throw new ResourceNotFoundException(friendId);
        repository.deleteByFriendIdAndUserId(friendId, getUserId());
        repository.deleteByFriendIdAndUserId(getUserId(), friendId);
    }

    @Override
    public List<FriendDto> getFriends() {
        return mapper.toReadDTOs(repository.findAllByUserId(getUserId()));
    }
}
