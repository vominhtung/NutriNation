package com.galaxy.service.Impl;

import com.galaxy.dto.response.MealDtoResponse;
import com.galaxy.dto.response.OrderDtoResponse;
import com.galaxy.entity.Meal;
import com.galaxy.mapper.MealMapper;
import com.galaxy.repository.IMealRepository;
import com.galaxy.service.IMealService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MealServiceImpl implements IMealService {
    private final IMealRepository mealRepository;
    private final MealMapper mealMapper;

    @Override
    public List<MealDtoResponse> findAll() {
        List<Meal> meals = mealRepository.findAll();
        log.info("get meals successfully");
        return mealMapper.entitiesToDtos(meals);
    }

    @Override
    public MealDtoResponse findById(Long id) {
        Meal meal = mealRepository.findById(id).get();
        log.info("get meal successfully {}", meal.getName());
        return mealMapper.entityToDto(meal);
    }

    @Override
    public OrderDtoResponse save(MealDtoResponse mealDtoResponse) {

        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
