package com.example.webback.business.entity;

import com.example.webback.business.enums.StatusFriends;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "friends")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Builder
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
