package com.capg.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capg.model.Customer;

@Repository
public interface ICustomerRepo extends CrudRepository<Customer, Integer> {

}
