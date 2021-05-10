package com.capg.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.model.OrderDetails;
import com.capg.repository.IOrderDetailsRepo;

@Transactional
@Service
public class OrderDetailsServiceImpl {
	
	@Autowired
	private IOrderDetailsRepo orderRepo;
	
	public void putOrder(OrderDetails order) {
		orderRepo.save(order);
	}
	
	public void deleteOrder(int id) {
		orderRepo.deleteById(id);
	}
	
	public List<OrderDetails> getAll(){
		return (List<OrderDetails>) orderRepo.findAll();
	}
	
	public List<OrderDetails> findByCartId(int id){
		return orderRepo.findAllByCartId(id); 
	}
	
	
}
