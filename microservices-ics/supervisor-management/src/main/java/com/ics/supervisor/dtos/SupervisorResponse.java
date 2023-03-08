package com.ics.supervisor.dtos;

import com.ics.supervisor.models.GeoCode;
import com.ics.supervisor.models.Supervisor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.implementation.bind.annotation.Super;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SupervisorResponse {
    private int supervisorId;
    private String username;
    private String firstName;
    private String lastName;
    private int marketId;
    private int userId;
    private List<GeoCode> location;
    private String area;
    private String city;
    private String state;
    private String areaLatitude;
    private String areaLongitude;
//    private Set<SupervisorAreaMapping> mainOutletArea = new HashSet<>();

}
