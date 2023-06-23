package com.galaxy.service;

import com.galaxy.dto.response.DishDtoResponse;
import com.galaxy.entity.Dish;

import java.util.List;

public interface IDishService extends IGeneralService<DishDtoResponse> {
    List<DishDtoResponse> getDishByBmi(Long bmiId, Long mealId);
}
