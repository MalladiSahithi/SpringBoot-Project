package com.cms.serviceimpl;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.dto.CustomerDTO;
import com.cms.entity.Customer;
import com.cms.repository.CustomerRepository;
import com.cms.service.CustomerService;
import com.cms.util.CustomerConverter;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	CustomerConverter customerConverter;
	
	@Override
	public CustomerDTO addCustomer(Customer customer) {
		Customer c=customerRepository.save(customer);
		return customerConverter.convertToCustomerDTO(customer);
	}

	@Override
	public List<CustomerDTO> getAllCustomers() {
		List<Customer> customers=customerRepository.findAll();
		List<CustomerDTO> dtoList=new ArrayList<>();
		for(Customer c:customers)
		{
			dtoList.add(customerConverter.convertToCustomerDTO(c));
		}
		return dtoList;
	}

	@Override
	public CustomerDTO getCustomerById(int id) {
		Customer customer=customerRepository.findById(id).get();
		return customerConverter.convertToCustomerDTO(customer);
	}

	@Override
	public CustomerDTO updateCustomer(int id, Customer customer) {
		Customer c=customerRepository.findById(id).get();
		c.setName(customer.getName());
		c.setAddress(customer.getAddress());
		c.setEmail(customer.getEmail());
		c.setPhnNumber(customer.getPhnNumber());
		Customer c1=customerRepository.save(c);
		return customerConverter.convertToCustomerDTO(c1);
	}
	@Override
	public String deleteCustomer(int id) {
		customerRepository.deleteById(id);
		return "Company details got deleted successfuly";
	}

	@Override
	public List<CustomerDTO> getCustomerByPhnNumber(String phnNumber) {
		return customerRepository.findCustomerByPhnNumber(phnNumber);
	}

	@Override
	public List<CustomerDTO> getCustomerByName(String name) {
		// TODO Auto-generated method stub
		return customerRepository.findCustomerByName(name);
	}

	
}
