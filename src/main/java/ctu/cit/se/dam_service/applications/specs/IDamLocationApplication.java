package ctu.cit.se.dam_service.applications.specs;

import ctu.cit.se.dam_service.dtos.requests.damlocations.CreateDamLocationReqDTO;
import ctu.cit.se.dam_service.dtos.requests.damlocations.UpdateDamLocationReqDTO;
import ctu.cit.se.dam_service.dtos.requests.damtypes.CreateDamTypeReqDTO;
import ctu.cit.se.dam_service.dtos.requests.damtypes.UpdateDamTypeReqDTO;
import ctu.cit.se.dam_service.dtos.responses.commands.CommandResDTO;
import ctu.cit.se.dam_service.dtos.responses.damlocations.RetrieveDamLocationResDTO;
import ctu.cit.se.dam_service.dtos.responses.damtypes.RetrieveDamTypeResDTO;

import java.util.List;
import java.util.UUID;

public interface IDamLocationApplication {
    CommandResDTO create(CreateDamLocationReqDTO createDamLocationReqDTO);
    CommandResDTO update(UpdateDamLocationReqDTO updateDamLocationReqDTO);
    List<RetrieveDamLocationResDTO> list();
    RetrieveDamLocationResDTO retrieve(UUID damLocationId);
    void delete(UUID damLocationId);
}
