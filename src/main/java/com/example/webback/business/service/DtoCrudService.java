package com.example.webback.business.service;

import com.example.webback.web.dto.ParentDto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

public interface DtoCrudService<I extends Serializable, R extends ParentDto,
        C extends ParentDto>{
    List<R> findAllDto();

    I saveDto(@NotNull C dto);

    void update(@NotNull C dto);

    void delete(@NotNull I id);
}
