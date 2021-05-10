package com.capg.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capg.model.Cart;

@Repository
public interface ICartRepo extends CrudRepository<Cart, Integer> {
	public Cart findBycId(int cId);

}
