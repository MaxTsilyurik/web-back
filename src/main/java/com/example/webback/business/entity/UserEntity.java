package com.example.webback.business.entity;


import com.example.webback.business.enums.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "users")
@Getter
@Setter
@EqualsAndHashCode(exclude = {"comments", "messages", "friends"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = {"comments", "messages", "friends"})
public class UserEntity implements UserDetails, Serializable {

    private static final long serialVersionUID = 1905122041950251207L;

    @Id
    @GeneratedValue(generator = "UserUUIDGenerator")
    @GenericGenerator(name = "UserUUIDGenerator", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Email
    @NotEmpty
    @Column(name = "username")
    private String username;

    @Column(name = "phone")
    private String phone;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotEmpty
    @Column(name = "user_password")
    private String password;

    @Column(name = "gender")
    @Enumerated(EnumType.ORDINAL)
    @NotNull
    private Gender gender;

    @Column(name = "account_confirmed")
    private boolean accountConfirmed;

    @Column(name = "account_expired")
    private boolean accountExpired;

    @Column(name = "account_locked")
    private boolean accountLocked;

    @Column(name = "credentials_expired")
    private boolean credentialsExpired;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "date_time_create")
    @CreatedDate
    private LocalDateTime dateTimeCreate;

    @Column(name = "date_time_modif")
    @LastModifiedDate
    private LocalDateTime dateTimeModif;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private transient List<CommentEntity> comments;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private transient List<MessagesEntity> messages;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private transient List<FriendEntity> friends;




    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user2authority",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id",
                    referencedColumnName = "id"))
    @OrderBy
    private Set<AuthorityEntity> userAuthorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return userAuthorities;
    }




    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return !isAccountExpired();
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return !isAccountLocked();
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return !isCredentialsExpired();
    }

    public void addAuthority(AuthorityEntity authority) {
        if (userAuthorities == null) {
            userAuthorities = new HashSet<>();
        }
        userAuthorities.add(authority);
    }
}
