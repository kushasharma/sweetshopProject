package com.capg.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capg.model.OrderDetails;

@Repository
public interface IOrderDetailsRepo extends CrudRepository<OrderDetails, Integer> {
	public List<OrderDetails> findAllByCartId(int cartId);

}
