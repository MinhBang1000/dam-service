package ctu.cit.se.dam_service.applications.specs;

import ctu.cit.se.dam_service.dtos.requests.dams.CreateDamReqDTO;
import ctu.cit.se.dam_service.dtos.requests.dams.UpdateDamReqDTO;
import ctu.cit.se.dam_service.dtos.requests.damtypes.CreateDamTypeReqDTO;
import ctu.cit.se.dam_service.dtos.requests.damtypes.UpdateDamTypeReqDTO;
import ctu.cit.se.dam_service.dtos.responses.commands.CommandResDTO;
import ctu.cit.se.dam_service.dtos.responses.dams.RetrieveDamResDTO;
import ctu.cit.se.dam_service.dtos.responses.damtypes.RetrieveDamTypeResDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

public interface IDamTypeApplication {
    CommandResDTO create(CreateDamTypeReqDTO createDamTypeReqDTO);
    CommandResDTO update(UpdateDamTypeReqDTO updateDamTypeReqDTO);
    List<RetrieveDamTypeResDTO> list();
    RetrieveDamTypeResDTO retrieve(UUID damTypeId);
    void delete(UUID damTypeId);
}
