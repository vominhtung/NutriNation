package com.galaxy.service.Impl;

import com.galaxy.dto.response.OrderDtoResponse;
import com.galaxy.entity.Bmi;
import com.galaxy.repository.IBmiRepository;
import com.galaxy.service.IBmiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BmiServiceImpl implements IBmiService {

    private final IBmiRepository bmiRepository;

    @Override
    public List<Bmi> findAll() {
        return bmiRepository.findAll();
    }

    @Override
    public Bmi findById(Long id) {
        return bmiRepository.findById(id).get();
    }

    @Override
    public OrderDtoResponse save(Bmi bmi) {

        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
