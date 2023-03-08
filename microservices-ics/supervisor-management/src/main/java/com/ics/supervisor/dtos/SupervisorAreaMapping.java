package com.ics.supervisor.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SupervisorAreaMapping {

    private String latitude;
    private String longitude;
    private String area;
    private String city;
    private String state;
}
