package com.galaxy.service;

import com.galaxy.dto.response.CustomerDtoResponse;
import com.galaxy.entity.Customer;
import com.galaxy.entity.Dish;

import java.util.List;

public interface ICustomerService extends IGeneralService<CustomerDtoResponse> {
    Customer findByEmail (String email);
    Customer updateCustomer(CustomerDtoResponse customerDtoResponse);

}
