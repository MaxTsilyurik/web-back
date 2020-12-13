package com.example.webback.web.mapper;

import org.mapstruct.Named;

import java.util.List;

public interface GenericReadMapper<RD, E> {
    //ReadDto
    @Named("toReadDTO")
    RD toReadDTO(E entity);
    @Named("toReadDTOs")
    List<RD> toReadDTOs(List<E> entites);
    //Entity
    E fromReadDTO(RD readDto);
    List<E> fromReadDTOs(List<RD> readDtos);
}
