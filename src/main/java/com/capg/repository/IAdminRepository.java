package com.capg.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.capg.model.Admin;


@Repository
public interface IAdminRepository extends CrudRepository<Admin,Integer> {
	
}