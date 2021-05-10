package com.capg.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.model.Admin;
import com.capg.model.Customer;
import com.capg.model.OrderDetails;
import com.capg.model.Sweet;
import com.capg.service.AdminServiceImpl;
import com.capg.service.CustomerServiceImpl;
import com.capg.service.OrderDetailsServiceImpl;

	@RestController
	@RequestMapping("/admin")
	public class AdminController {
		@Autowired
		private AdminServiceImpl adminService;
		@Autowired
		private CustomerServiceImpl customerService;
		@Autowired
		private OrderDetailsServiceImpl orderService;
		
		@PostMapping(path="/addAdmin",consumes="application/json")
		public void add(@RequestBody Admin admin) {
			adminService.addAdmin(admin);
		}
		
		@PostMapping(path="/addSweet",consumes="application/json")
		public void add(@RequestBody Sweet sweet) {
			adminService.addSweet(sweet);
		}
		
		@GetMapping(path = "/allSweets", produces = "application/json")
		public List<Sweet> getallSweets() {
			return adminService.getAllSweets();
		}
		
		@PostMapping(path="/updateSweet",consumes="application/json")
		public void updateSweet(@RequestBody Sweet sweet) {
			adminService.updateSweet(sweet);
		}
		
		@DeleteMapping(path="/deleteSweet/{id}")
		public void deleteSweet(@PathVariable int id) {
			adminService.deleteSweet(id);
		}
		
		@GetMapping(path = "/sweetbyid/{id}", produces = "application/json")
		public ResponseEntity<Sweet> getSweetById(@PathVariable int id) {
			Sweet s=adminService.getSweetById(id);
			if (null == s) {
				throw new SweetNotFoundException("Cart not available for " + id);
			}
			return new ResponseEntity<Sweet>(s,HttpStatus.OK);
		}
		
		@GetMapping(path = "/allcustomer", produces = "application/json")
		public List<Customer> getall() {
			return customerService.getAllCustomer();
		}
		
		@GetMapping(path = "/orderbycartid/{id}", produces = "application/json")
		public List<OrderDetails> getOrderByCartId(@PathVariable int id) {
			return orderService.findByCartId(id);

		}
		
		@GetMapping(path = "/seeAllOrders", produces = "application/json")
		public List<OrderDetails> seeAllOrders(){
			return orderService.getAll();

		}
		
		@DeleteMapping(path="/delete/{id}")
		public void deleteOrder(@PathVariable int id) {
			orderService.deleteOrder(id);
		}
	}