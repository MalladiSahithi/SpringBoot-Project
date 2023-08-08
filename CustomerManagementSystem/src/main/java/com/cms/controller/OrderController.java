package com.cms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cms.dto.OrderDTO;
import com.cms.entity.Order;
import com.cms.exception.ResourceNotFoundException;
import com.cms.service.OrderService;
import com.cms.util.OrderConverter;

@RestController
public class OrderController {
	@Autowired
	OrderService orderService;
	
	@PostMapping("/addOrder")
	ResponseEntity<Order> addOrder(@RequestBody @Valid 	OrderDTO orderDTO){
		try {
			Order order=orderService.addOrder(orderDTO);
			if(order!=null) {
				return new ResponseEntity<Order>(order,HttpStatus.CREATED);
			}
		}
		catch(Exception e) {
			throw new ResourceNotFoundException("Order data is not entered properly,check it");
		}
		return new ResponseEntity<Order>(HttpStatus.BAD_REQUEST);
	}
	@GetMapping("/getAllOrder")
	ResponseEntity<List<OrderDTO>> getAllOrderS()
	{
		return new ResponseEntity<List<OrderDTO>>(orderService.getAllOrders(),HttpStatus.FOUND);
	}
	@GetMapping("/getOrderById/{id}")
	ResponseEntity<OrderDTO> getCustomerById(@PathVariable int id)
	{
		return new ResponseEntity<OrderDTO>(orderService.getOrderById(id),HttpStatus.FOUND);
	}
	@GetMapping("/getorderbyPrice")
	ResponseEntity<Order> getOrderByPrice(@PathVariable double price){
		return new ResponseEntity<Order>(HttpStatus.OK);
	}
	@GetMapping("/getorderbyname")
	ResponseEntity<Order> getOrderByName(@PathVariable String name){
		return new ResponseEntity<Order>(HttpStatus.OK);
	}

}
