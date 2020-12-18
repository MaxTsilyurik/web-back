package com.example.webback.web.api.v1;

import com.example.webback.business.entity.UserEntity;
import com.example.webback.business.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.webback.utils.ApiConstant.USER;


@RestController
@RequestMapping(USER)
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public UserEntity getById(@PathVariable Long id){
        return userService.getById(id);
    }
}
