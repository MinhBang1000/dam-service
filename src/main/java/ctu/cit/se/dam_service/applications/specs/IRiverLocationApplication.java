package ctu.cit.se.dam_service.applications.specs;

import ctu.cit.se.dam_service.dtos.requests.damtypes.CreateDamTypeReqDTO;
import ctu.cit.se.dam_service.dtos.requests.damtypes.UpdateDamTypeReqDTO;
import ctu.cit.se.dam_service.dtos.requests.riverlocations.CreateRiverLocationReqDTO;
import ctu.cit.se.dam_service.dtos.requests.riverlocations.UpdateRiverLocationReqDTO;
import ctu.cit.se.dam_service.dtos.responses.commands.CommandResDTO;
import ctu.cit.se.dam_service.dtos.responses.damtypes.RetrieveDamTypeResDTO;
import ctu.cit.se.dam_service.dtos.responses.riverlocations.RetrieveRiverLocationResDTO;

import java.util.List;
import java.util.UUID;

public interface IRiverLocationApplication {
    CommandResDTO create(CreateRiverLocationReqDTO createRiverLocationReqDTO);
    CommandResDTO update(UpdateRiverLocationReqDTO updateRiverLocationReqDTO);
    List<RetrieveRiverLocationResDTO> list();
    RetrieveRiverLocationResDTO retrieve(UUID riverLocationId);
    void delete(UUID riverLocationId);
}
