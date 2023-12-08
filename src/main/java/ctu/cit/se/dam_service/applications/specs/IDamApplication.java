package ctu.cit.se.dam_service.applications.specs;

import ctu.cit.se.dam_service.dtos.requests.dams.CreateDamReqDTO;
import ctu.cit.se.dam_service.dtos.requests.dams.UpdateDamReqDTO;
import ctu.cit.se.dam_service.dtos.responses.commands.CommandResDTO;
import ctu.cit.se.dam_service.dtos.responses.dams.RetrieveDamResDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

public interface IDamApplication {
    CommandResDTO create(CreateDamReqDTO createDamReqDTO);
    CommandResDTO update(UpdateDamReqDTO updateDamReqDTO);
    List<RetrieveDamResDTO> list();
    RetrieveDamResDTO retrieve(UUID damId);
    void delete(UUID damId);
}
