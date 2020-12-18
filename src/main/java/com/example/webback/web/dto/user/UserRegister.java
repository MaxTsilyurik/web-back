package com.example.webback.web.dto.user;

import com.example.webback.business.enums.AuthorityEnum;
import com.example.webback.business.enums.Gender;
import com.example.webback.web.dto.ParentDto;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class UserRegister implements ParentDto {
    private String username;
    private String phone;
    private String password;
    private String firstName;
    private String secondName;
    private String patronymic;
    private Integer executorTypeId;
    @Enumerated(EnumType.STRING)
    private AuthorityEnum authority;
    @Enumerated(EnumType.STRING)
    private Gender gender;
}
