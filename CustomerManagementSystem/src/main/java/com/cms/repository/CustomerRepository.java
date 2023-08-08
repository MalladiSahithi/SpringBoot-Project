package com.cms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cms.dto.CustomerDTO;
import com.cms.entity.Customer;


public interface CustomerRepository extends JpaRepository<Customer,Integer>{
	List<CustomerDTO> findCustomerByPhnNumber(String phnNumber);
	List<CustomerDTO> findCustomerByName(String name);
}
