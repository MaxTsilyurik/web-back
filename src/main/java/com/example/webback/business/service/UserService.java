package com.example.webback.business.service;

import com.example.webback.business.entity.AuthorityEntity;
import com.example.webback.business.entity.UserEntity;
import com.example.webback.business.enums.AuthorityEnum;
import com.example.webback.web.dto.user.UserDto;
import com.example.webback.web.dto.user.UserRegister;
import com.example.webback.web.dto.user.UserUpdate;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface UserService extends UserDetailsService {
    UserEntity findById(UUID id);

    UserEntity findByEmail(String email);

    UserDto findDtoById(UUID id);

    List<UserDto> findAllDto();

    void update(UserUpdate userDto);

    void delete(UUID id);

    UserEntity save(UserEntity user);

    AuthorityEntity findAuthorityByName(AuthorityEnum authority);

    UUID register(UserRegister newUser);

    void confirmUser(UserEntity user);

    void blockSwitch(UUID userId);

    Map<String, Object> getAdditionInformation(OAuth2Authentication auth);

    List<UserEntity> byAuthority(String authorityName);
}
