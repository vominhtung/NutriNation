package com.galaxy.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDtoRequest {
    private String name;
    private String address;
    private String email;
    private String phone;
    private String gender;
    private String password;
    private Integer age;
    private boolean isStatus = true;
}
