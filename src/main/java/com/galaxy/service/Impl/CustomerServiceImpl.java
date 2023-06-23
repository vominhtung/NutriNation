package com.galaxy.service.Impl;

import com.galaxy.dto.response.CustomerDtoResponse;
import com.galaxy.dto.response.OrderDtoResponse;
import com.galaxy.entity.Customer;
import com.galaxy.mapper.CustomerMapper;
import com.galaxy.repository.ICustomerRepository;
import com.galaxy.service.ICustomerService;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements ICustomerService {


    private final ICustomerRepository customerRepository;

    private final CustomerMapper customerMapper;

    @Override
    public List<CustomerDtoResponse> findAll() {
        List<Customer> customers = customerRepository.findAllCustomers();
        List<CustomerDtoResponse> customerDtoResponses;
        customerDtoResponses =  customerMapper.entitiesToDtos(customers);
        return customerDtoResponses;
    }


    @Override
    public CustomerDtoResponse findById(Long id) {
        Customer customer = customerRepository.findById(id).get();
        CustomerDtoResponse customerDtoResponse = customerMapper.entityToDto(customer);
        return customerDtoResponse;
    }
    @Override
    public OrderDtoResponse save(CustomerDtoResponse customerDtoResponse) {
        Customer customer = customerMapper.DtoToEntity(customerDtoResponse);
        customerRepository.save(customer);
        return null;
    }
    @Override
    @Transactional
    public void remove(Long id) {
           customerRepository.deleteCustomerById(id);
    }

    public Customer findByEmail (String email) {
        Customer customer =customerRepository.findByEmail(email);
        return customer;
    }

    @Override
    public Customer updateCustomer(CustomerDtoResponse customerDtoResponse) {
        Customer customer =  customerRepository.findById(customerDtoResponse.getId()).get();
        BeanUtils.copyProperties(customerDtoResponse, customer);
        customerRepository.save(customer);
        return customer;
    }

}
