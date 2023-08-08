 package com.cms.service;

import java.util.List;
import com.cms.dto.CustomerDTO;
import com.cms.entity.Customer;

public interface CustomerService {
	CustomerDTO addCustomer(Customer customer);
	List<CustomerDTO> getAllCustomers();
	CustomerDTO getCustomerById(int id);
	CustomerDTO updateCustomer(int id,Customer customer);
	String deleteCustomer(int id);
	List<CustomerDTO> getCustomerByPhnNumber(String phnNumber);
	List<CustomerDTO> getCustomerByName(String name);
}
