package com.example.webback.web.dto.user;

import com.example.webback.business.enums.Gender;
import com.example.webback.web.dto.ParentDto;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.UUID;

@Data
public class UserUpdate implements ParentDto {
    private UUID id;
    private String username;
    private String password;
    private String firstName;
    private String secondName;
    private String patronymic;
    private Boolean updatePassword;
    @Enumerated(EnumType.STRING)
    private Gender gender;

}
