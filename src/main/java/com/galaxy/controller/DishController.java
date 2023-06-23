package com.galaxy.controller;

import com.galaxy.dto.request.DishDtoRequest;
import com.galaxy.dto.response.CustomerDtoResponse;
import com.galaxy.dto.response.DishDtoResponse;
import com.galaxy.dto.response.MealDtoResponse;
import com.galaxy.entity.Bmi;
import com.galaxy.entity.Customer;
import com.galaxy.entity.Dish;
import com.galaxy.entity.Meal;
import com.galaxy.service.IBmiService;
import com.galaxy.service.ICustomerService;
import com.galaxy.service.IDishService;
import com.galaxy.service.IMealService;
import com.galaxy.service.Impl.DishServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class DishController {
    private final IDishService dishService;
    private final ICustomerService customerService;
    private final IBmiService bmiService;
    private  final IMealService mealService;
    @ModelAttribute(name="bmis")
    public List<Bmi> sendBmi(){
        return bmiService.findAll();
    }

//    @ModelAttribute(name="meals")
//    public List<MealDtoResponse> sendMeal(){
//        return mealService.findAll();
//    }

    @GetMapping("/dishes/{customerId}/{mealId}")
    public ModelAndView getDishByBmi(@PathVariable(name = "customerId")Long customerId,
                                     @PathVariable(name = "mealId")Long mealId){
        ModelAndView modelAndView = new ModelAndView("/dish/list-bmi");
        Long bmiId = customerService.findById(customerId).getBmi().getId();
        modelAndView.addObject("dishes", dishService.getDishByBmi(bmiId, mealId));
        modelAndView.addObject("bmi", bmiId);
        modelAndView.addObject("customerId",customerId );
        return modelAndView;
    }
    @GetMapping("/dish/create")
    public  ModelAndView CreateDish(){
        ModelAndView modelAndView = new ModelAndView("/dish/create");
        modelAndView.addObject("dish", new DishDtoRequest());
        return modelAndView;
    }

    @PostMapping("/dish/create")
    public ModelAndView CreateDish(@ModelAttribute("dish") DishDtoResponse dishDtoResponse){
        dishService.save(dishDtoResponse);
        ModelAndView modelAndView = new ModelAndView("/dish/create");
        modelAndView.addObject("message", "Create Dish Successfully");
        return modelAndView;

    }
    @GetMapping("/dish/delete/{id}")
    public ModelAndView DeleteDish(@PathVariable(name = "id") Long id){
        ModelAndView modelAndView = new ModelAndView("/dish/delete");
        modelAndView.addObject("dish",dishService.findById(id));
        return modelAndView;
    }
    @PostMapping("/dish/delete/{id}")
    public ModelAndView Delete(@PathVariable(name = "id") Long id){
        ModelAndView modelAndView = new ModelAndView("redirect:/dish/list");
        modelAndView.addObject("message","Delete Dish Successfully ");
        dishService.remove(id);
        return modelAndView;
    }
    @GetMapping("/dish/list")
    public ModelAndView Dish(){
        ModelAndView modelAndView = new ModelAndView("/dish/list");
        modelAndView.addObject("dishes",dishService.findAll());
        return modelAndView;
    }

    @GetMapping("/dish/display/{customerId}/{id}")
    public ModelAndView display(@PathVariable(name = "customerId")Long customerId, @PathVariable(name = "id")Long id){
        ModelAndView modelAndView = new ModelAndView("/dish/display");
        modelAndView.addObject("customerId", customerId);
        modelAndView.addObject("dishes",dishService.findById(id));
        return modelAndView;
    }

  @GetMapping("/dish/display/{id}")
    public ModelAndView displayDish( @PathVariable(name = "id")Long id){
        ModelAndView modelAndView = new ModelAndView("/dish/display");
        modelAndView.addObject("dishes",dishService.findById(id));
        return modelAndView;
    }

    @GetMapping("/dish/edit/{id}")
    public ModelAndView getFormEdit(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/dish/edit");
        modelAndView.addObject("dish", dishService.findById(id));
        return modelAndView;
    }

    @PostMapping("/dish/edit")
    public ModelAndView editDish(@ModelAttribute DishDtoResponse dishDtoResponse) {
        ModelAndView modelAndView = new ModelAndView("redirect:/dish/list");
        dishService.save(dishDtoResponse);
        return modelAndView;
    }
}
