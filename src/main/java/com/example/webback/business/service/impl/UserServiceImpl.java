package com.example.webback.business.service.impl;

import com.example.webback.business.dao.AuthorityRepository;
import com.example.webback.business.dao.UserRepository;
import com.example.webback.business.entity.AuthorityEntity;
import com.example.webback.business.entity.UserEntity;
import com.example.webback.business.enums.AuthorityEnum;
import com.example.webback.business.service.UserService;
import com.example.webback.web.dto.user.UserDto;
import com.example.webback.web.dto.user.UserRegister;
import com.example.webback.web.dto.user.UserUpdate;
import com.example.webback.web.error.NotAccessException;
import com.example.webback.web.error.ResourceNotFoundException;
import com.example.webback.web.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;

    private static final PasswordEncoder PASSWORD_ENCODER = PasswordEncoderFactories.createDelegatingPasswordEncoder();


    @Override
    @SneakyThrows
    public UserEntity loadUserByUsername(String email)  {
        return findByEmail(email);
    }

    @Override
    public UserEntity findById(UUID id) {
        return userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(id.toString()));
    }

    @Override
    public UserEntity findByEmail(String email) {
        return userRepository.findByUsername(email).orElseThrow(() -> new ResourceNotFoundException("User", email));
    }

    @Override
    public UserDto findDtoById(UUID id) {
        return userMapper.toReadDTO(findById(id));
    }

    @Override
    public List<UserDto> findAllDto() {
        return userMapper.toReadDTOs(userRepository.findAll());
    }

    @Override
    public void update(UserUpdate userDto) {
        checkResolution(userDto.getId());
        UserEntity entity = userRepository
                .findById(userDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException(userDto));
        userMapper.updateFromDTO(userDto,entity);
        userRepository.save(entity);
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        checkResolution(id);
        UserEntity entity = userRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        userRepository.delete(entity);
    }

    

    @Override
    public UserEntity save(UserEntity user) {
        user.setPassword(PASSWORD_ENCODER.encode(user.getPassword()));
        return userRepository.save(user);
    }


    @Override
    public AuthorityEntity findAuthorityByName(AuthorityEnum authority) {
        return authorityRepository.findAllByName(authority.name());
    }


    @Override
    public UUID register(UserRegister newUser) {
        UserEntity user =
                UserEntity.builder()
                        .enabled(true)
                        .accountConfirmed(true)
                        .password(newUser.getPassword())
                        .username(newUser.getUsername())
                        .firstName(newUser.getFirstName())
                        .secondName(newUser.getSecondName())
                        .patronymic(newUser.getPatronymic())
                        .phone(newUser.getPhone())
                        .gender(newUser.getGender())
                        .build();
        user.addAuthority(findAuthorityByName(newUser.getAuthority()));
        return save(user).getId();
    }

    @Override
    public void confirmUser(UserEntity user) {
        user.setAccountConfirmed(true);
        userRepository.save(user);
    }

    @Override
    public void blockSwitch(UUID userId) {
        Optional<UserEntity> user = userRepository.findById(userId);
        user.ifPresent(u -> {
            u.setAccountLocked(!u.isAccountLocked());
            userRepository.save(u);
        });
    }

    @Override
    @SneakyThrows
    public Map<String, Object> getAdditionInformation(OAuth2Authentication auth) {
        var details = (OAuth2AuthenticationDetails) auth.getDetails();
        return (Map<String, Object>) details.getDecodedDetails();
    }

    @Override
    public List<UserEntity> byAuthority(String authorityName) {
        return userRepository.findByAuthority(authorityName);
    }

    @Override
    public void checkResolution(UUID id) {
        if (!isAccess(id))
            throw new NotAccessException("Нет доступа");

    }

    private boolean isAccess(UUID id) {
        String userId = getAdditionInformation(getOAuth2Authentication()).get("user_id").toString();
        return id.toString().equals(userId);
    }

    private OAuth2Authentication getOAuth2Authentication() {
        return (OAuth2Authentication) SecurityContextHolder.getContext().getAuthentication();
    }


}
