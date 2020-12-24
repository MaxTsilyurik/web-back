package com.example.webback.business.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
@Entity(name = "comments")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class CommentEntity extends ParentEntity<Long>{

    @Column
    private String comment;

    @Column(name = "date_time_create")
    @CreatedDate
    private LocalDateTime dateTimeCreate;

    @Column(name = "date_time_modif")
    @LastModifiedDate
    private LocalDateTime dateTimeModif;

    @CreatedBy
    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private UserEntity author;

    @ManyToOne
    @JoinColumn(name = "messages_id", referencedColumnName = "id")
    private MessagesEntity message;
}
