package com.cms.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.cms.dto.OrderDTO;
import com.cms.entity.Order;

@Component
public class OrderConverter {
	public Order convertToOrderEntity(OrderDTO orderDTO) {
		Order order=new Order();
		if(orderDTO!=null) {
			BeanUtils.copyProperties(orderDTO, order);
		}
		return order;
	}
	public OrderDTO convertToOrderDTO(Order order) {
		OrderDTO orderDTO=new OrderDTO();
		if(order!=null) {
			BeanUtils.copyProperties(order, orderDTO);
		}
		return orderDTO;
	}
}
