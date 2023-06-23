package com.galaxy.service.Impl;

import com.galaxy.dto.response.DishDtoResponse;
import com.galaxy.dto.response.OrderDtoResponse;
import com.galaxy.entity.Dish;
import com.galaxy.entity.Order;
import com.galaxy.mapper.DishMapper;
import com.galaxy.repository.IDishRepository;
import com.galaxy.service.IDishService;

import java.util.List;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class DishServiceImpl implements IDishService {
    private final IDishRepository dishRepository;
    private final DishMapper dishMapper;

    public List<DishDtoResponse> getDishByBmi(Long bmiId, Long mealId){
        List<Dish> dishes =  dishRepository.findDishes(bmiId, mealId);
        log.info("get dishes by bmi successfully ");
       List<DishDtoResponse> dishDtoResponseList = dishMapper.entitiesToDtos(dishes);
     return   dishDtoResponseList;
    }

    @Override
    public List<DishDtoResponse> findAll() {
        List<Dish> dishes = dishRepository.findAllDishes();
        log.info("get dishes successfully ");
        List<DishDtoResponse> dishDtoResponses;
        dishDtoResponses = dishMapper.entitiesToDtos(dishes);
        return dishDtoResponses;
    }

    @Override
    public DishDtoResponse findById(Long id) {
        Dish dish = dishRepository.findById(id).get();
        log.info("get dish by bmi successfully : {}", dish.getName());
        DishDtoResponse dishDtoResponse = dishMapper.entityToDto(dish);
        return dishDtoResponse;
    }


    @Override
    public OrderDtoResponse save(DishDtoResponse dishDtoResponse) {
        Dish dish = dishMapper.DtoToEntity(dishDtoResponse);
        dishRepository.save(dish);
        return null;
    }

    @Override
    public void remove(Long id) {
        dishRepository.deleteDishById(id);

    }


}
