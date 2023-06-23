package com.galaxy.repository;

import com.galaxy.entity.Customer;
import com.galaxy.entity.Dish;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDishRepository extends JpaRepository<Dish, Long> {

//    @Query("SELECT d FROM Dish d " +
//            "JOIN Meal m ON m.id = d.meal.id" +
//            " JOIN Customer c ON c.bmi.id = d.bmi.id " +
//            "WHERE c.bmi.id= :bmiId AND m.id = :mealId")
//    @Query("SELECT d FROM Dish d " +
//            "JOIN Meal m ON m.id = d.meal.id " +
//            "JOIN Customer c ON c.bmi.id = d.bmi.id " +
//            "WHERE c.bmi.id = : bmiId AND m.id = : mealId ")
//    List<Dish> findDishes(@Param("bmiId") Long bmiId, @Param("mealId") Long mealId);

    @Query("SELECT d FROM Dish d " +
            "JOIN Meal m ON m.id = d.meal.id" +
            " JOIN Customer c ON c.bmi.id = d.bmi.id " +
            "WHERE c.bmi.id= :bmiId AND m.id = :mealId")
    List<Dish> findDishes(@Param("bmiId") Long bmiId, @Param("mealId") Long mealId);
    @Modifying
    @Query( value = "update Dish d set d.status = false where d.id = :id")
    void deleteDishById(@Param("id") Long id);

    @Modifying
    @Query( value = "select d from Dish d where d.status = true ")
    List<Dish> findAllDishes();


}
