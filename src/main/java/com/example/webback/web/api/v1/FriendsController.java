package com.example.webback.web.api.v1;

import com.example.webback.business.service.FriendsService;
import com.example.webback.web.dto.friend.FriendDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static com.example.webback.utils.ApiConstant.FRIENDS;

@RequestMapping(FRIENDS)
@RestController
@RequiredArgsConstructor
public class FriendsController {
    private final FriendsService service;

    @PostMapping("/{id}")
    public void addFriend(@PathVariable UUID id){
        service.addFriend(id);
    }

    @PutMapping("/{id}")
    public void confirmFriend(@PathVariable UUID id){
        service.confirmFriend(id);
    }

    @DeleteMapping("/{id}")
    public void deleteFriend(@PathVariable UUID id){
        service.deleteFriend(id);
    }

    @GetMapping
    public List<FriendDto> getAllFriend(){
        return service.getFriends();
    }
}
