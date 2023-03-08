package com.ics.supervisor.services.impl;

import com.ics.supervisor.dtos.SupervisorAreaMapping;
import com.ics.supervisor.dtos.SupervisorResponse;
import com.ics.supervisor.exception.ResourceNotFoundException;
import com.ics.supervisor.models.GeoCode;
import com.ics.supervisor.models.Supervisor;
import com.ics.supervisor.repositorys.GeoCodesRepository;
import com.ics.supervisor.repositorys.SupervisorRepository;
import com.ics.supervisor.services.SupervisorService;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
public class SupervisorServiceImpl implements SupervisorService {
    @Autowired
    private SupervisorRepository supervisorRepository;
    @Autowired
    private GeoCodesRepository geoCodesRepository;
    @Override
    public Supervisor save(Supervisor supervisor) {
         Supervisor supervisor1 = null;
         supervisor1 = supervisorRepository.save(supervisor);
         if(supervisor1 instanceof Supervisor) {
             log.info("supervisor response");
             List<GeoCode> response = supervisor.getGeoCodes();
             for (GeoCode geoCode : response) {
                 geoCode.setSupervisor(supervisor1);
                 geoCodesRepository.save(geoCode);
             }
             return supervisor1;
         }else{
             new ResourceNotFoundException("Supervisor not save!");
         }
         return null;
    }
    @Override
    public SupervisorResponse getMarketId(int id) {
        Optional<Supervisor> userInfo = supervisorRepository.getByMarketId(id);
        if(userInfo.isPresent()) {
            int supervisorId = userInfo.get().getId(); // supervisor table PK
            int supervisor_id = userInfo.get().getSupervisor_id(); // // supervisor table FK
            int userId = userInfo.get().getUserId();
            int marketId = userInfo.get().getMarketId();
            log.info("supervisorId , marketId are fetching");
            String username = userInfo.get().getUsername();
            String firstName = userInfo.get().getFirstname();
            String lastname = userInfo.get().getLastname();
            List<GeoCode> geoCodes = geoCodesRepository.findBySupervisorId(supervisorId);
            log.info("groCodes fetching");
            return SupervisorResponse.builder()
                    .userId(userId)
                    .supervisorId(supervisor_id)
                    .username(username)
                    .marketId(marketId)
                    .firstName(firstName)
                    .lastName(lastname)
                    .area("Ho Chi Minh City")
                    .city("Bình Tân")
                    .state("Vietnam")
                    .areaLatitude("10.76932")
                    .areaLongitude("106.5917421")
                    .location(geoCodes)
                    .build();
        }else{
            new ResourceNotFoundException("Market ID :"+id+" Not Found!");
        }
        return null;
    }
}
