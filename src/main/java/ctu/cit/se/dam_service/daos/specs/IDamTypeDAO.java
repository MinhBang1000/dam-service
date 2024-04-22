package ctu.cit.se.dam_service.daos.specs;

import ctu.cit.se.dam_service.dtos.requests.dams.CreateDamReqDTO;
import ctu.cit.se.dam_service.dtos.requests.dams.UpdateDamReqDTO;
import ctu.cit.se.dam_service.dtos.requests.damtypes.CreateDamTypeReqDTO;
import ctu.cit.se.dam_service.dtos.requests.damtypes.UpdateDamTypeReqDTO;
import ctu.cit.se.dam_service.dtos.responses.commands.CommandResDTO;
import ctu.cit.se.dam_service.dtos.responses.dams.RetrieveDamResDTO;
import ctu.cit.se.dam_service.dtos.responses.damtypes.RetrieveDamTypeResDTO;
import ctu.cit.se.dam_service.entites.DamType;

import java.util.List;
import java.util.UUID;

public interface IDamTypeDAO {
    CommandResDTO create(CreateDamTypeReqDTO createDamTypeReqDTO);
    CommandResDTO update(UpdateDamTypeReqDTO updateDamTypeReqDTO);
    List<RetrieveDamTypeResDTO> list();
    RetrieveDamTypeResDTO retrieve(UUID damTypeId);
    void delete(UUID damTypeId);
    void createInitData(List<DamType> damTypes);
}
