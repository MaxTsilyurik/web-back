package com.example.webback.web.mapper;

import com.example.webback.business.entity.UserEntity;
import com.example.webback.web.dto.user.UserDto;
import com.example.webback.web.dto.user.UserRegister;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper extends GenericMapper<UserRegister, UserEntity>, GenericReadMapper<UserDto, UserEntity>{
}
