package com.example.webback.web.dto.user;

import com.example.webback.business.entity.AuthorityEntity;
import com.example.webback.web.dto.ParentDto;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Set;
import java.util.UUID;

@Data
public class UserDto implements ParentDto {
    private UUID id;
    @NotBlank
    private String username;
    private String firstName;
    private String secondName;
    private String patronymic;
    private Set<AuthorityEntity> userAuthorities;
    private String phone;
}
