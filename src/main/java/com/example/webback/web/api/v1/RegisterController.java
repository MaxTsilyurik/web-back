package com.example.webback.web.api.v1;

import com.example.webback.business.service.UserService;
import com.example.webback.web.dto.user.UserRegister;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("api/register")
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UUID register(@RequestBody UserRegister user) {
        return userService.register(user);
    }
}
