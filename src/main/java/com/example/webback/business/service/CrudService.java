package com.example.webback.business.service;

import com.example.webback.business.entity.ParentEntity;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

public interface CrudService<E extends ParentEntity<I>, I extends Serializable> {
    E findById(@NotNull I id);

    List<E> findAll();

    void deleteAll();

    void delete(@NotNull I id);

    E save(@NotNull E entity);

    List<E> saveAll(@NotNull List<E> entities);

    Boolean isExist(@NotNull I id);

    Number count();
}
