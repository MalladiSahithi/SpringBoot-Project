package com.cms.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.cms.dto.CustomerDTO;
import com.cms.entity.Customer;
@Component
public class CustomerConverter {
	public Customer convertToCustomerEntity(CustomerDTO customerDTO) {
		Customer customer=new Customer();
		if(customerDTO!=null) {
			BeanUtils.copyProperties(customerDTO, customer);
		}
		return customer;
	}
	public CustomerDTO convertToCustomerDTO(Customer customer) {
		CustomerDTO customerDTO=new CustomerDTO();
		if(customer!=null) {
			BeanUtils.copyProperties(customer, customerDTO);
		}
		return customerDTO;
	}
}
