package com.capg.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.model.Customer;
import com.capg.model.OrderDetails;
import com.capg.model.Sweet;
import com.capg.model.UserLogin;
import com.capg.service.CustomerServiceImpl;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerServiceImpl customerService;
	
	@PostMapping(path="/add",consumes="application/json")
	public void add(@RequestBody Customer addcust) {
		customerService.addCustomer(addcust);
	}
	
	//LOGIN CUSTOMER
	@PostMapping(path="/userAuth",consumes="application/json")
	public boolean userAuth(@RequestBody UserLogin loginCust) {
		return customerService.loginCustomer(loginCust);
	}
	
	@GetMapping(path = "/searchallsweets", produces = "application/json")
	public List<Sweet> getall() {
		return customerService.getAllSweets();

	}	
	
	@GetMapping(path = "/seecart/{id}", produces = "application/json")
	public ResponseEntity<List<OrderDetails>> seeCart(@PathVariable int id) {
		List<OrderDetails> ord=customerService.seeCart(id);
			if (null == ord) {
				throw new CartNotFoundException("Cart not available for " + id);
			}
			return new ResponseEntity<List<OrderDetails>>(ord, HttpStatus.OK);
	}
	
	@PostMapping(path="/buy",consumes="application/json")
	public void add(@RequestBody OrderDetails order) {
		customerService.OrderSweet(order);
	}
	
	@GetMapping(path = "/generatebill/{id}")
	public void seeBill(@PathVariable int id) {
		 customerService.generateBill(id);
	}
}