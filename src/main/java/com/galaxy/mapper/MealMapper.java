package com.galaxy.mapper;

import com.galaxy.dto.response.MealDtoResponse;
import com.galaxy.entity.Meal;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MealMapper {

    public List<MealDtoResponse> entitiesToDtos(List<Meal> meals){
        List<MealDtoResponse> mealDtoResponseList = new ArrayList<>();
        meals.forEach(meal -> mealDtoResponseList.add(entityToDto(meal)));
        return mealDtoResponseList;
    }
    public MealDtoResponse entityToDto(Meal meal){
        MealDtoResponse mealDtoResponse = new MealDtoResponse();
        BeanUtils.copyProperties(meal,mealDtoResponse );
        return mealDtoResponse;
    }
}
