package com.galaxy.controller;

import com.galaxy.service.ICustomerService;
import com.galaxy.service.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class OrderController {
    private final IOrderService orderService;
    private final ICustomerService customerService;

    @GetMapping("adddishtoorder/{dishId}/{customerId}")
    public ModelAndView addDishToOrder(@PathVariable(name = "dishId") Long dishId,
                                       @PathVariable(name = "customerId") Long customerId) {
        ModelAndView modelAndView = new ModelAndView("/order/list");
        Long orderId = customerService.findById(customerId).getOrder().getId();
        orderService.addDishToOrder(dishId, orderId);
        modelAndView.addObject("customerId", customerId);
        modelAndView.addObject("order", orderService.findById(orderId));
        modelAndView.addObject("orderId", orderId);
        return modelAndView;
    }

    @GetMapping("deletedishinorder/{dishId}/{customerId}")
    public ModelAndView deleteDishInOrder(@PathVariable(name = "dishId") Long dishId,
                                          @PathVariable(name = "customerId") Long customerId) {
        ModelAndView modelAndView = new ModelAndView("/order/list");
        modelAndView.addObject("customerId", customerId);
        Long orderId = customerService.findById(customerId).getOrder().getId()  ;
        orderService.deleteDishInOrder(dishId, orderId);
        modelAndView.addObject("order", orderService.findById(orderId));
        return modelAndView;
    }
}
