package com.cms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cms.dto.OrderDTO;
import com.cms.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Integer>{
	List<OrderDTO> findOrderByName(String name);
	List<OrderDTO> findOrderByPrice(double price);
}
