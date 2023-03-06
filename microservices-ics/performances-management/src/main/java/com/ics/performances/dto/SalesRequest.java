package com.ics.performances.dto;

import com.ics.performances.model.TargetAchievement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SalesRequest {
    private TargetAchievement targetAchievement;
}
