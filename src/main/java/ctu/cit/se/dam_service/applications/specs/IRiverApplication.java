package ctu.cit.se.dam_service.applications.specs;

import ctu.cit.se.dam_service.dtos.requests.damtypes.CreateDamTypeReqDTO;
import ctu.cit.se.dam_service.dtos.requests.damtypes.UpdateDamTypeReqDTO;
import ctu.cit.se.dam_service.dtos.requests.rivers.CreateRiverReqDTO;
import ctu.cit.se.dam_service.dtos.requests.rivers.UpdateRiverReqDTO;
import ctu.cit.se.dam_service.dtos.responses.damtypes.RetrieveDamTypeResDTO;
import ctu.cit.se.dam_service.dtos.responses.rivers.RetrieveRiverResDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

public interface IRiverApplication {
    void create(CreateRiverReqDTO createRiverReqDTO);
    void update(UpdateRiverReqDTO updateRiverReqDTO);
    List<RetrieveRiverResDTO> list();
    RetrieveRiverResDTO retrieve(UUID riverId);
    void delete(UUID riverId);
}
