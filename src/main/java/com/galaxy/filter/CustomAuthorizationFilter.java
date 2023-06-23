package com.galaxy.filter;

import com.galaxy.entity.Customer;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class CustomAuthorizationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        Customer customer = (Customer) req.getSession().getAttribute("userLogged");
        if(request.getServletPath().equals("/login") || request.getServletPath().equals("/registry")
                ||request.getServletPath().equals("/")){
            chain.doFilter(request, response);
        }
        if(customer == null){

        }
    }
}