package com.example.webback.business.entity;

import com.example.webback.business.enums.Gender;
import com.example.webback.business.enums.StatusFriends;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "friends")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FriendEntity extends ParentEntity<Long>{

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "friend_id", referencedColumnName = "id")
    private UserEntity friend;

    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    @NotNull
    private StatusFriends status;

}
