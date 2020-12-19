package com.example.webback.business.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "authority")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class AuthorityEntity extends ParentEntity<Integer> implements GrantedAuthority {

    @NotBlank
    private String name;

    private String description;

    @Column(name = "date_time_create")
    @CreatedDate
    private LocalDateTime dateTimeCreate;

    @Column(name = "date_time_modif")
    @LastModifiedDate
    private LocalDateTime dateTimeModif;

    @Override
    @JsonIgnore
    public String getAuthority() {
        return getName();
    }
}
