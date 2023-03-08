package com.ics.supervisor.repositorys;

import com.ics.supervisor.models.Supervisor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SupervisorRepository extends JpaRepository<Supervisor, Integer> {

    Optional<Supervisor> getByMarketId(Integer id);

}
