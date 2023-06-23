package com.galaxy.mapper;

import com.galaxy.dto.response.CustomerDtoResponse;
import com.galaxy.entity.Customer;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerMapper {
    public List<CustomerDtoResponse> entitiesToDtos(List<Customer> customers) {
        List<CustomerDtoResponse> customerDtoResponses = new ArrayList<>();
        for(Customer element : customers){
            CustomerDtoResponse customerDto = entityToDto(element);
            customerDtoResponses.add(customerDto);
        }
        return customerDtoResponses;
    }
    public CustomerDtoResponse entityToDto(Customer customer){
        CustomerDtoResponse  customerDtResponse = new CustomerDtoResponse();
        BeanUtils.copyProperties(customer, customerDtResponse);
        return customerDtResponse;
    }
    public Customer DtoToEntity(CustomerDtoResponse customerDtoResponse){
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDtoResponse, customer);
        return customer;
    }
}
