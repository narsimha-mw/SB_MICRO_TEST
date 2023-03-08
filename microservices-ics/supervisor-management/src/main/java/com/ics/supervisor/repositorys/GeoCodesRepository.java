package com.ics.supervisor.repositorys;

import com.ics.supervisor.models.GeoCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GeoCodesRepository extends JpaRepository<GeoCode, Integer> {
//    @Query("SELECT go from geo_code go where go.supervisor_id = :supervisor_id ")
//    List<GeoCode> fetchBySupervisorId(@Param("supervisor_id") int superVisorId);
      List<GeoCode> findBySupervisorId(int superVisorId);

}
