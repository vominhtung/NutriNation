package com.galaxy.repository;

import com.galaxy.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    @Modifying
    @Query( value = "update Customer c set c.isStatus = false where c.id = :id")
    void deleteCustomerById(@Param("id") Long id);

    @Modifying
    @Query( value = "select c from Customer c where c.isStatus = true ")
    List<Customer> findAllCustomers();

    Customer findByEmail (String email);
}
