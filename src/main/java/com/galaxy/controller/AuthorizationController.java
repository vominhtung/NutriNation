package com.galaxy.controller;

import com.galaxy.dto.request.CustomerDtoRequest;
import com.galaxy.dto.response.CustomerDtoResponse;
import com.galaxy.dto.response.OrderDtoResponse;
import com.galaxy.entity.Bmi;
import com.galaxy.entity.Customer;
import com.galaxy.entity.Order;
import com.galaxy.normal.Login;
import com.galaxy.normal.Register;
import com.galaxy.service.IBmiService;
import com.galaxy.service.ICustomerService;
import com.galaxy.service.IMealService;
import com.galaxy.service.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class AuthorizationController {
    private final ICustomerService customerService;
    private final IBmiService bmiService;
    private  final IOrderService orderService;
    private final IMealService mealService;
    @GetMapping("/home")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("/login");
        modelAndView.addObject("login",new Login());
        return modelAndView;
    }
    @PostMapping("/login")
    public ModelAndView getAll(@ModelAttribute("login") Login login){
        ModelAndView modelAndView ;
        String email = login.getEmail();
        String password = login.getPassword();
        Customer customer = customerService.findByEmail(email);
        if(customer != null && customer.getPassword().equals(password)){
            if(email.equals("nguyenvana@gmail.com")){
                modelAndView = new ModelAndView("redirect:/customer/list");
            }else {
                modelAndView = new ModelAndView("/meal/list");
                modelAndView.addObject("meals", mealService.findAll());
                modelAndView.addObject("customerId", customer.getId());
            }
        }else {
            modelAndView = new ModelAndView("/login");
            modelAndView.addObject("message","Login failed !");
        }
            return modelAndView;
    }
    @GetMapping("/register")
    public ModelAndView registerForm(){
        ModelAndView modelAndView = new ModelAndView("/register");
        modelAndView.addObject("register", new Register());
        return modelAndView;
    }
    @PostMapping("/register")
    public ModelAndView register(@ModelAttribute (name = "register") Register register){
        ModelAndView modelAndView = new ModelAndView("/register");
        modelAndView.addObject("message", "Registered successfully !");
        Long bmiId = bmiHandler(register.getWeight(), register.getHeight());
        CustomerDtoResponse customerDtoResponse = new CustomerDtoResponse();
        BeanUtils.copyProperties(register, customerDtoResponse);
        Bmi bmi = bmiService.findById(bmiId);
        OrderDtoResponse orderDtoResponse = new OrderDtoResponse();
        Order order = orderService.saveEntity(orderDtoResponse);
        customerDtoResponse.setBmi(bmi);
        customerDtoResponse.setOrder(order);
        customerService.save(customerDtoResponse);
        return modelAndView;
    }
    public Long bmiHandler(Double weight, Double height){
        Double result = weight / ( height * 2);
        if(result <= 18.5){
            return 1L;
        } else if(result <= 22.9){
            return 2L;
        } else if(result <= 29.9){
            return  3L;
        } else {
            return 4L;
        }
    }
}
