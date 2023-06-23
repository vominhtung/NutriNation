package com.galaxy.mapper;

import com.galaxy.dto.response.DishDtoResponse;
import com.galaxy.entity.Dish;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DishMapper {
    public List<DishDtoResponse> entitiesToDtos(List<Dish> dishes) {
        List<DishDtoResponse> dishDtoResponses = new ArrayList<>();
        for (Dish element : dishes) {
            DishDtoResponse dishDtoResponse = entityToDto(element);
            dishDtoResponses.add(dishDtoResponse);
        }
        return dishDtoResponses;
    }

    public DishDtoResponse entityToDto(Dish dish){
        DishDtoResponse dishDtoResponse = new DishDtoResponse();
//        dishDtoResponse.setId(dish.getId());
        BeanUtils.copyProperties(dish, dishDtoResponse);
        return dishDtoResponse;
    }
    public Dish DtoToEntity(DishDtoResponse dishDtoResponse){
        Dish dish = new Dish();
        BeanUtils.copyProperties(dishDtoResponse , dish);
        return dish;
    }
}
