package com.cms.serviceimpl;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cms.dto.OrderDTO;

import com.cms.entity.Order;
import com.cms.repository.CustomerRepository;
import com.cms.repository.OrderRepository;
import com.cms.service.OrderService;
import com.cms.util.OrderConverter;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderConverter orderConverter;
	
	@Autowired
	CustomerRepository customerRepository;
		

	@Override
	public OrderDTO addOrder(Order order) {
		Order o=orderRepository.save(order);
		return orderConverter.convertToOrderDTO(order);
	}

	@Override
	public List<OrderDTO> getAllOrders() {
		List<Order> orders=orderRepository.findAll();
		List<OrderDTO> dtoList=new ArrayList<>();
		for(Order o:orders)
		{
			dtoList.add(orderConverter.convertToOrderDTO(o));
		}
		return dtoList;
	}

	@Override
	public OrderDTO getOrderById(int id) {
		Order order=orderRepository.findById(id).get();
		return orderConverter.convertToOrderDTO(order);
	}

	@Override
	public List<OrderDTO> getOrderByName(String name) {
		
		return orderRepository.findOrderByName(name);
	}

	@Override
	public List<OrderDTO> getOrderByPrice(double price) {
		
		return orderRepository.findOrderByPrice(price);
	}

	@Override
	public Order addOrder(OrderDTO orderDTO) {
		Order order=Order.builder()
				.id(orderDTO.getId())
				.name(orderDTO.getName())
				.price(orderDTO.getPrice())
				.customer(orderDTO.getCustomer())
				.build();
		return orderRepository.save(order);
	}
}
