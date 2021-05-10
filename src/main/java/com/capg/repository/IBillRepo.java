package com.capg.repository;

import org.springframework.data.repository.CrudRepository;
import com.capg.model.Bill;

public interface IBillRepo extends CrudRepository<Bill, Integer> {

}
