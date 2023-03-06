package com.ics.performances.services;

import com.ics.performances.dto.SalesRequest;
import com.ics.performances.model.Sales;
import com.ics.performances.model.TargetAchievement;
import com.ics.performances.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalesServiceImpl implements SalesService{

    @Autowired
    private SalesRepository salesRepository;
    @Override
    public Sales save(TargetAchievement req) {
        Sales sales = Sales.builder()
                .achievement(req.getAchievement())
                .target(req.getTarget())
                .build();
      return salesRepository.save(sales);
    }
}
