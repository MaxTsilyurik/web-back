package com.example.webback.business.entity;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
public class MessagesEntity {
    private Long id;
    private String message;
    private UserEntity author;

    public MessagesEntity(Long id, String message, UserEntity author) {
        this.id = id;
        this.message = message;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public void setAuthor(UserEntity author) {
        this.author = author;
    }
}
