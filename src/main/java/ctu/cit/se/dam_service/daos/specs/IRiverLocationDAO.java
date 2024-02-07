package ctu.cit.se.dam_service.daos.specs;

import ctu.cit.se.dam_service.dtos.requests.damlocations.CreateDamLocationReqDTO;
import ctu.cit.se.dam_service.dtos.requests.damlocations.UpdateDamLocationReqDTO;
import ctu.cit.se.dam_service.dtos.requests.riverlocations.CreateRiverLocationReqDTO;
import ctu.cit.se.dam_service.dtos.requests.riverlocations.UpdateRiverLocationReqDTO;
import ctu.cit.se.dam_service.dtos.responses.commands.CommandResDTO;
import ctu.cit.se.dam_service.dtos.responses.damlocations.RetrieveDamLocationResDTO;
import ctu.cit.se.dam_service.dtos.responses.riverlocations.RetrieveRiverLocationResDTO;

import java.util.List;
import java.util.UUID;

public interface IRiverLocationDAO {
    CommandResDTO create(CreateRiverLocationReqDTO createRiverLocationReqDTO);
    CommandResDTO update(UpdateRiverLocationReqDTO updateRiverLocationReqDTO);
    List<RetrieveRiverLocationResDTO> list();
    RetrieveRiverLocationResDTO retrieve(UUID riverLocationId);
    void delete(UUID riverLocationId);
}
