package com.galaxy.service.Impl;

import com.galaxy.dto.response.OrderDtoResponse;
import com.galaxy.entity.Dish;
import com.galaxy.entity.Order;
import com.galaxy.mapper.OrderMapper;
import com.galaxy.repository.IDishRepository;
import com.galaxy.repository.IOrderRepository;
import com.galaxy.service.IOrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements IOrderService {
    private final IOrderRepository orderRepository;
    private final IDishRepository dishRepository;
    private final OrderMapper  orderMapper;

    @Override
    public OrderDtoResponse findById(Long id) {
        Order order = orderRepository.findById(id).get();
        log.info("get order successfully {}", order.getName());
        return orderMapper.entityToDto(order);
    }

    @Override
    public void addDishToOrder(Long dishId, Long orderId) {
      Dish dish = dishRepository.findById(dishId).get();
      Order order = orderRepository.findById(orderId).get();
      log.info("add dish to order successfully {} to {}", dish.getName(), order.getName());
      order.getDishes().add(dish);
      orderRepository.save(order);
    }

    @Override
    public void deleteDishInOrder(Long dishId, Long orderId) {
        Dish dish = dishRepository.findById(dishId).get();
        Order order = orderRepository.findById(orderId).get();
        log.info("delete dish in order successfully {} to {}", dish.getName(), order.getName());
        Collection<Dish> dishes =  order.getDishes();
       if(dishes.contains(dish)){
           dishes.remove(dish);
       };
       orderRepository.save(order);
    }
    @Override
    public Order saveEntity(OrderDtoResponse orderDtoResponse) {
        Order order = orderMapper.DtoToEntity(orderDtoResponse);
        orderRepository.save(order);
        return order;
    }
    @Override
    public List<OrderDtoResponse> findAll() {
        return null;
    }

    @Override
    public OrderDtoResponse save(OrderDtoResponse orderDtoResponse) {
            Order order = orderMapper.DtoToEntity(orderDtoResponse);
            orderRepository.save(order);
        return orderDtoResponse;
    }

    @Override
    public void remove(Long id) {

    }
}
