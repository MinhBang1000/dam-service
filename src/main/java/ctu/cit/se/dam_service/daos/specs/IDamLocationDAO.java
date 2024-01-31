package ctu.cit.se.dam_service.daos.specs;

import ctu.cit.se.dam_service.dtos.requests.damlocations.CreateDamLocationReqDTO;
import ctu.cit.se.dam_service.dtos.requests.damlocations.UpdateDamLocationReqDTO;
import ctu.cit.se.dam_service.dtos.requests.rivers.CreateRiverReqDTO;
import ctu.cit.se.dam_service.dtos.requests.rivers.UpdateRiverReqDTO;
import ctu.cit.se.dam_service.dtos.responses.commands.CommandResDTO;
import ctu.cit.se.dam_service.dtos.responses.damlocations.RetrieveDamLocationResDTO;
import ctu.cit.se.dam_service.dtos.responses.rivers.RetrieveRiverResDTO;

import java.util.List;
import java.util.UUID;

public interface IDamLocationDAO {
    CommandResDTO create(CreateDamLocationReqDTO createDamLocationReqDTO);
    CommandResDTO update(UpdateDamLocationReqDTO updateDamLocationReqDTO);
    List<RetrieveDamLocationResDTO> list();
    RetrieveDamLocationResDTO retrieve(UUID damLocationId);
    void delete(UUID damLocationId);
}
