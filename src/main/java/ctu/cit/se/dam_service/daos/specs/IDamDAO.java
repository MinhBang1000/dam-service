package ctu.cit.se.dam_service.daos.specs;

import ctu.cit.se.dam_service.dtos.requests.dams.CreateDamReqDTO;
import ctu.cit.se.dam_service.dtos.requests.dams.UpdateDamReqDTO;
import ctu.cit.se.dam_service.dtos.responses.commands.CommandResDTO;
import ctu.cit.se.dam_service.dtos.responses.dams.RetrieveDamResDTO;

import java.util.List;
import java.util.UUID;

public interface IDamDAO  {
    CommandResDTO create(CreateDamReqDTO createDamReqDTO);
    CommandResDTO update(UpdateDamReqDTO updateDamReqDTO);
    List<RetrieveDamResDTO> list();
    RetrieveDamResDTO retrieve(UUID damId);
    void delete(UUID damId);
}
