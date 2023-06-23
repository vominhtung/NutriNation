package com.galaxy.mapper;

import com.galaxy.dto.response.OrderDtoResponse;
import com.galaxy.entity.Order;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderMapper {
    public List<OrderDtoResponse> entitiesToDtos(List<Order> orders){
        List<OrderDtoResponse> orderDtoResponseList = new ArrayList<>();
        orders.forEach(order -> orderDtoResponseList.add(entityToDto(order)));
        return orderDtoResponseList;
    }

    public OrderDtoResponse entityToDto(Order order){
        OrderDtoResponse orderDtoResponse = new OrderDtoResponse();
        BeanUtils.copyProperties(order, orderDtoResponse);
        return orderDtoResponse;
    }
    public Order DtoToEntity(OrderDtoResponse orderDtoResponse){
        Order order = new Order();
        BeanUtils.copyProperties(orderDtoResponse, order);
        return order;
    }
}
