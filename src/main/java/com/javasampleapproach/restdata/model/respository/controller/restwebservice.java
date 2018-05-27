package com.javasampleapproach.restdata.model.respository.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.javasampleapproach.restdata.model.Customer;
import com.javasampleapproach.restdata.repository.CustomerRepository;

@RestController
@RequestMapping("/customers")
public class restwebservice {
	@Autowired
	CustomerRepository customerRepository;
	
	@ResponseBody
	@RequestMapping(value = "/insertTestData" , method = RequestMethod.GET ) 
	public void addEmployee(){
		
		customerRepository.save(new Customer("Jack", "Smith","sfjbsfjbsfjb"));
		customerRepository.save(new Customer("Adam", "Johnson","bjsbjsbj"));
		customerRepository.save(new Customer("Kim", "Smith","jsbjsbjsb"));
		customerRepository.save(new Customer("David", "Williams","svhsfhsvfhsv"));
		customerRepository.save(new Customer("Peter", "Davis","vhsvhsvcfhsvß"));
	}
	
	
	
	//request  body customer
	@ResponseBody
	@RequestMapping(value = "/addCustomer" , method = RequestMethod.POST , consumes = {"application/json"} ) 
		public String addCustomer(@RequestBody Customer cus){
		
		customerRepository.save(cus);
		return "Saved Succefully"+cus.getId();
	}
	
	@RequestMapping(value = "/GETCustomerLastname" , method = RequestMethod.POST , consumes = {"application/json"} ) 
	public List<Customer> GETCustomerLastname(@RequestBody  String Lastname){
		List<Customer> list = customerRepository.findByLastName(Lastname);
		
		return list;
	}
	
		
}