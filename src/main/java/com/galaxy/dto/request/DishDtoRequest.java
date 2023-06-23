package com.galaxy.dto.request;

import com.galaxy.entity.Bmi;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DishDtoRequest {
    private String name;
    private Double calo;
    private  Double price;
    private Bmi bmi;
    private Boolean status = true;
}
