package com.example.webback.web.mapper;

import com.example.webback.business.entity.UserEntity;
import com.example.webback.web.dto.user.UserDto;
import com.example.webback.web.dto.user.UserRegister;
import com.example.webback.web.dto.user.UserUpdate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Mapper
public interface UserMapper extends GenericMapper<UserRegister, UserEntity>, GenericReadMapper<UserDto, UserEntity>{

    @Mapping(target = "password", expression = "java(checkUpdatePassword(userCreateDto, userEntity.getPassword() ))")
    void updateFromDTO(UserUpdate userCreateDto, @MappingTarget UserEntity userEntity);


    default String checkUpdatePassword(UserUpdate userCreateDto, String oldPassword){
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return userCreateDto.getUpdatePassword() ? passwordEncoder.encode(userCreateDto.getPassword()) : oldPassword;
    }

}
