package ctu.cit.se.dam_service.daos.specs;

import ctu.cit.se.dam_service.dtos.requests.dams.CreateDamReqDTO;
import ctu.cit.se.dam_service.dtos.requests.dams.UpdateDamReqDTO;
import ctu.cit.se.dam_service.dtos.requests.damtypes.CreateDamTypeReqDTO;
import ctu.cit.se.dam_service.dtos.requests.damtypes.UpdateDamTypeReqDTO;
import ctu.cit.se.dam_service.dtos.responses.dams.RetrieveDamResDTO;
import ctu.cit.se.dam_service.dtos.responses.damtypes.RetrieveDamTypeResDTO;

import java.util.List;
import java.util.UUID;

public interface IDamTypeDAO {
    void create(CreateDamTypeReqDTO createDamTypeReqDTO);
    void update(UpdateDamTypeReqDTO updateDamTypeReqDTO);
    List<RetrieveDamTypeResDTO> list();
    RetrieveDamTypeResDTO retrieve(UUID damTypeId);
    void delete(UUID damTypeId);
}
