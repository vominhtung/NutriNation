package com.galaxy.dto.response;

import com.galaxy.entity.Bmi;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DishDtoResponse {
    private Long id;
    private String name;
    private Double calo;
    private Double price;
    private Bmi bmi;
    private  Boolean status = true;

}
