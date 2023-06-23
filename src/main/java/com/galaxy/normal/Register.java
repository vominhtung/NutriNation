package com.galaxy.normal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Register {
    private String name;
    private String address;
    private String email;
    private String  phone;
    private String gender;
    private String password;
    private Integer age;
    private  Boolean isStatus = true;
    private Double height;
    private Double weight;
}
