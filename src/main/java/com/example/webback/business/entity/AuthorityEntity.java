package com.example.webback.business.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

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

    @Override
    @JsonIgnore
    public String getAuthority() {
        return getName();
    }
}
