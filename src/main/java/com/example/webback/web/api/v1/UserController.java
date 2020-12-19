package com.example.webback.web.api.v1;

import com.example.webback.business.service.UserService;
import com.example.webback.web.dto.user.UserDto;
import com.example.webback.web.dto.user.UserRegister;
import com.example.webback.web.dto.user.UserUpdate;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static com.example.webback.utils.ApiConstant.USER;


@RestController
@RequestMapping(USER)
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @DeleteMapping("/{userId}")
    public void delete(@PathVariable UUID userId) {
        userService.delete(userId);
    }

    @GetMapping("/{userId}")
    public UserDto get(@PathVariable UUID userId) {
        return userService.findDtoById(userId);
    }

    @GetMapping
    public List<UserDto> getAll() {
        return userService.findAllDto();
    }

    @PutMapping
    public void update(@Valid @RequestBody UserUpdate userDto) {
        userService.update(userDto);
    }
}
