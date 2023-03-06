package com.ics.performances.services;

import com.ics.performances.dto.SalesRequest;
import com.ics.performances.model.Sales;
import com.ics.performances.model.TargetAchievement;

public interface SalesService {
    Sales save(TargetAchievement sales);
}
