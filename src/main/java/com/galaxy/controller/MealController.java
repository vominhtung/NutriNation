package com.galaxy.controller;

import com.galaxy.service.ICustomerService;
import com.galaxy.service.IMealService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class MealController {
    private final IMealService mealService;
    private final ICustomerService customerService;

    @GetMapping("/meals")
    public ModelAndView getMeals(){
        ModelAndView modelAndView = new ModelAndView("/meal/list");
        modelAndView.addObject("meals", mealService.findAll());
        modelAndView.addObject("bmi", customerService.findById(1L).getBmi().getId());
        return modelAndView;
    }
    @GetMapping("/meals/{customerId}")
    public ModelAndView getMeal(@PathVariable(name = "customerId") Long customerId){
        ModelAndView modelAndView = new ModelAndView("/meal/list");
        modelAndView.addObject("meals", mealService.findAll());
        modelAndView.addObject("bmi", customerService.findById(customerId).getBmi().getId());
        return modelAndView;
    }
}
