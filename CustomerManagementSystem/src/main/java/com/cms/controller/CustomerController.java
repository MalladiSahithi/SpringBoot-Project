package com.cms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cms.dto.CustomerDTO;
import com.cms.entity.Customer;
import com.cms.service.CustomerService;
import com.cms.util.CustomerConverter;

@RestController
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@Autowired
	CustomerConverter customerConverter;
	
	@PostMapping("/addCustomers")
	ResponseEntity<CustomerDTO> addCustomer(@RequestBody @Valid CustomerDTO customerDTO){
		Customer customer=customerConverter.convertToCustomerEntity(customerDTO);
		return new ResponseEntity<CustomerDTO>(customerService.addCustomer(customer),HttpStatus.CREATED);
	}
	@GetMapping("/getCustomerById/{id}")
	ResponseEntity<CustomerDTO> getCustomerById(@PathVariable int id)
	{
		return new ResponseEntity<CustomerDTO>(customerService.getCustomerById(id),HttpStatus.FOUND);
	}
	
	@GetMapping("/getAllCustomer")
	ResponseEntity<List<CustomerDTO>> getCustomers()
	{
		return new ResponseEntity<List<CustomerDTO>>(customerService.getAllCustomers(),HttpStatus.FOUND);
	}
	
	@PutMapping("/updateCustomer/{id}")
	ResponseEntity<CustomerDTO> updateCustomer(@PathVariable int id,@RequestBody CustomerDTO customerDTO)
	{
		Customer customer=customerConverter.convertToCustomerEntity(customerDTO);
		return new ResponseEntity<CustomerDTO>(customerService.updateCustomer(id, customer),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteCustomerById/{id}")
	ResponseEntity<String> deleteCustomerById(@PathVariable int id)
	{
		return new ResponseEntity<String>(customerService.deleteCustomer(id),HttpStatus.OK);
	}
	@GetMapping("/getCustomerbyphnNumber")
	ResponseEntity<CustomerDTO> getCustomerByPhnNumber(@PathVariable String phnNumber){
		return new ResponseEntity<CustomerDTO>(HttpStatus.OK);
	}
	@GetMapping("/getbookbyname")
	ResponseEntity<CustomerDTO> getBookByName(@PathVariable String name){
		return new ResponseEntity<CustomerDTO>(HttpStatus.OK);
	}
}
