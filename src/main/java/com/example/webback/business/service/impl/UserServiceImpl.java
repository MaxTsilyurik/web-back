package com.example.webback.business.service.impl;

import com.example.webback.business.entity.AuthorityEntity;
import com.example.webback.business.entity.UserEntity;
import com.example.webback.business.enums.AuthorityEnum;
import com.example.webback.business.service.UserService;
import com.example.webback.web.dto.user.UserDto;
import com.example.webback.web.dto.user.UserRegister;
import com.example.webback.web.dto.user.UserUpdate;
import lombok.SneakyThrows;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Override
    @SneakyThrows
    public UserDetails loadUserByUsername(String s)  {
        return null;
    }

    @Override
    public UserEntity findById(UUID id) {
        return null;
    }

    @Override
    public UserEntity findByEmail(String email) {
        return null;
    }

    @Override
    public UserDto findDtoById(UUID id) {
        return null;
    }

    @Override
    public List<UserDto> findAllDto() {
        return null;
    }

    @Override
    public void update(UserUpdate userDto) {

    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public UserEntity save(UserEntity user) {
        return null;
    }

    @Override
    public void addAuthority(UUID userId, Integer authorityId) {

    }

    @Override
    public void deleteAuthority(UUID userId, Integer authorityId) {

    }

    @Override
    public AuthorityEntity findAuthorityByName(AuthorityEnum authority) {
        return null;
    }

    @Override
    public UUID register(UserRegister newUser) {
        return null;
    }

    @Override
    public void confirmUser(UserEntity user) {

    }

    @Override
    public void blockSwitch(UUID userId) {

    }

    @Override
    public Map<String, Object> getAdditionInformation(OAuth2Authentication auth) {
        return null;
    }

    @Override
    public List<UserEntity> byAuthority(String authorityName) {
        return null;
    }
}
