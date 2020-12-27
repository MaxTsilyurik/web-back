package com.example.webback.web.mapper;

import com.example.webback.business.entity.FriendEntity;
import com.example.webback.web.dto.friend.FriendDto;
import org.mapstruct.Mapper;

@Mapper
public interface  FriendsMapper extends GenericReadMapper<FriendDto, FriendEntity> {
}
