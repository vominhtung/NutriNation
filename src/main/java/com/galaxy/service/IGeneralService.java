package com.galaxy.service;

import com.galaxy.dto.response.OrderDtoResponse;

import java.util.List;

public interface IGeneralService<T> {
    List<T> findAll();

    T findById(Long id);

    OrderDtoResponse save(T t);
    void remove(Long id);

}
