package com.example.webback.business.entity;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class UserEntity {
    private Long id;
    private String name;
    private String secondName;

    public UserEntity(Long id, String name, String secondName) {
        this.id = id;
        this.name = name;
        this.secondName = secondName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
}
