package com.ics.supervisor.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GeoCodeResponse {
    private String  latitude ;// geoCodeX
    private String longitude; // geoCodeY
}
