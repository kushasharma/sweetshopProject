package com.capg.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capg.model.UserLogin;
@Repository
public interface ILoginRepository extends CrudRepository<UserLogin,Integer> {

	UserLogin findById(int id);

}
