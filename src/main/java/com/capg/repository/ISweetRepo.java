package com.capg.repository;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.capg.model.Sweet;

@Repository
public interface ISweetRepo extends CrudRepository<Sweet, Integer>{
	Sweet findBySid(int sid);

}
