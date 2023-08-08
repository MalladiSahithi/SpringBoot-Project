package com.cms.service;

import java.util.List;

import javax.validation.Valid;

import com.cms.dto.CustomerDTO;
import com.cms.dto.OrderDTO;
import com.cms.entity.Customer;
import com.cms.entity.Order;

public interface OrderService {
	OrderDTO addOrder(Order order);
	List<OrderDTO> getAllOrders();
	OrderDTO getOrderById(int id);
	List<OrderDTO> getOrderByName(String name);
	List<OrderDTO> getOrderByPrice(double price);
	Order addOrder(OrderDTO orderDTO);
}
