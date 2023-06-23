package com.galaxy.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name="dish")
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double calo;
    private Double price;
    private Boolean status = true;

    @ManyToOne(targetEntity = Bmi.class)
    @JoinColumn(name = "bmi_id", referencedColumnName = "id")
    private Bmi bmi;

    @ManyToOne(targetEntity = Meal.class)
    @JoinColumn(name = "meal_id", referencedColumnName = "id")
    private Meal meal;
}
