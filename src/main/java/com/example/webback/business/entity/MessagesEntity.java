package com.example.webback.business.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@ToString(exclude = "comments")
@EqualsAndHashCode(callSuper = true, exclude = "comments")
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "messages")
public class MessagesEntity extends ParentEntity<Long>{

    @Column(name = "message")
    @NotBlank
    private String message;

    @Column(name = "uri_image")
    private String imageUri;

    @Column(name = "date_time_create")
    @CreatedDate
    private LocalDateTime dateTimeCreate;

    @Column(name = "date_time_modif")
    @LastModifiedDate
    private LocalDateTime dateTimeModif;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private UserEntity author;

    @OneToMany(mappedBy = "message",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<CommentEntity> comments;

    @ManyToMany
    @JoinTable(
            name = "likes",
            joinColumns =  @JoinColumn(name = "messages_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
     private Set<UserEntity> likes;

}
