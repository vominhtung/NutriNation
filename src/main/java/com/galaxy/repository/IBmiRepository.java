package com.galaxy.repository;

import com.galaxy.entity.Bmi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBmiRepository extends JpaRepository<Bmi, Long> {
}
