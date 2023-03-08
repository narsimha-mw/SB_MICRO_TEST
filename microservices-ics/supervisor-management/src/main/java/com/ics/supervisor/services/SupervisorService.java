package com.ics.supervisor.services;

import com.ics.supervisor.dtos.SupervisorResponse;
import com.ics.supervisor.models.Supervisor;
import org.json.JSONObject;

public interface SupervisorService {
    Supervisor save(Supervisor supervisor);

    SupervisorResponse getMarketId(int id);
}
