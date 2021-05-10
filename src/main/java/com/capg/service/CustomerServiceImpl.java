package com.capg.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.model.Cart;
import com.capg.model.Customer;
import com.capg.model.OrderDetails;
import com.capg.model.Sweet;
import com.capg.model.UserLogin;
import com.capg.repository.ICustomerRepo;
import com.capg.validation.UserValidation;

@Transactional
@Service
public class CustomerServiceImpl {
	@Autowired
	private ICustomerRepo customerRepo;
	@Autowired
	private CartServiceImpl cartService;
	@Autowired
	private OrderDetailsServiceImpl orderService;
	@Autowired
	private SweetServiceImpl sweetService;
	@Autowired
	private LoginServiceImpl loginService;
	@Autowired
	private UserValidation userValidation;
	
	public void addCustomer(Customer customer) {
		userValidation.validateUserFields(customer);
		customerRepo.save(customer);
		cartService.saveCart(new Cart(customer.getcId()));
		loginService.addUser(new UserLogin(customer.getcId(),customer.getcPassword()));
	}
	
	public List<Customer> getAllCustomer(){
		return (List<Customer>) customerRepo.findAll();
	}
	
//	public void buySweet(int customerId,int sweetId,int quantity) {
//		orderService.putOrder(new OrderDetails(cartService.findByCid(customerId).getCartId(), sweetId, quantity));
//	}
	
	public List<Sweet> getAllSweets(){
		return sweetService.getAllSweets();
	}
	
	public List<OrderDetails> seeCart(int custId){
		return orderService.findByCartId(cartService.findByCid(custId).getCartId());
	}
	
	public void OrderSweet(OrderDetails order) {
		orderService.putOrder(order);
	}
	
	public int generateBill(int custId) {
		List<OrderDetails> od=orderService.findByCartId(cartService.findByCid(custId).getCartId());
		int bill=0;
		for(OrderDetails orderit:od) {
			System.out.println(orderit.getsId()+" "+orderit.getoQty());
			int sweetId=orderit.getsId();
			int sweetQty=orderit.getoQty();
			Sweet tempSweet=sweetService.getSweetById(sweetId);
			double price= tempSweet.getsPrice();
			bill+=(price*sweetQty);	
		}
		System.out.println(bill);
		return bill;		
	}
	
	//LOGIN CUSTOMER
	public boolean loginCustomer(UserLogin loginCust) {
				UserLogin ul=loginService.getUserById(loginCust.getId());
					if(ul.getId()==loginCust.getId() && ul.getPassword().equals(loginCust.getPassword())) 
						return true;
					return false;	
	}
}