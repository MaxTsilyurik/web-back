package com.example.webback.business.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
@Entity(name = "comments")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentEntity extends ParentEntity<Long>{

    @Column
    private String comment;

    @Column(name = "date_time_create")
    @CreatedDate
    private LocalDateTime dateTimeCreate;

    @Column(name = "date_time_modif")
    @LastModifiedDate
    private LocalDateTime dateTimeModif;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private UserEntity author;

    @ManyToOne
    @JoinColumn(name = "messages_id", referencedColumnName = "id")
    private MessagesEntity message;
}
