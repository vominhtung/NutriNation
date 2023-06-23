package com.galaxy.repository;

import com.galaxy.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMealRepository extends JpaRepository<Meal, Long> {
}
