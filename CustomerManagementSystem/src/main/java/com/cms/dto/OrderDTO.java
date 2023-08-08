package com.cms.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.cms.entity.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
	
	@NotNull(message="Order Id should not be null")
	private int id;
	
	@NotBlank(message="Order Name should not be blank")
	@NotNull(message="Order Name should not be null")
	private String name;
	
	@NotNull
	private double price;
	
	Customer customer;
	
	
}
