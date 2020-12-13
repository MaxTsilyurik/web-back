package com.example.webback.web.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;

import java.util.List;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

public interface GenericMapper<D, E> {
    D toDTO(E entity);

    List<D> toDTOs(List<E> entities);

    E toEntity(D dto);

    List<E> toEntities(List<D> dtos);

    @BeanMapping(nullValuePropertyMappingStrategy = IGNORE)
    void updateFromDTO(D d, @MappingTarget E e);
}