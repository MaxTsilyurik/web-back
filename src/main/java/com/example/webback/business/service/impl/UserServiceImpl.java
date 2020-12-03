package com.example.webback.business.service.impl;

import com.example.webback.business.entity.UserEntity;
import com.example.webback.business.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    static List<UserEntity> init(){
        UserEntity userEntity = new UserEntity(1L,"Max","Tsilyurik");
        UserEntity userEntity2 = new UserEntity(2L, "Petr", "Ivanov");
        UserEntity userEntity3 = new UserEntity(3L, "Ricardo", "Milos");

        return List.of(userEntity,userEntity2,userEntity3);
    }

    @Override
    public UserEntity getById(Long id) {
        return init().stream().filter(i -> i.getId().equals(id)).findFirst().get();
    }
}
