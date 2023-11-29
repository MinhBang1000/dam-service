package ctu.cit.se.dam_service.applications.impls;

import ctu.cit.se.dam_service.applications.specs.IDamApplication;
import ctu.cit.se.dam_service.applications.specs.IDamTypeApplication;
import ctu.cit.se.dam_service.daos.specs.IDamDAO;
import ctu.cit.se.dam_service.daos.specs.IDamTypeDAO;
import ctu.cit.se.dam_service.dtos.requests.dams.CreateDamReqDTO;
import ctu.cit.se.dam_service.dtos.requests.dams.UpdateDamReqDTO;
import ctu.cit.se.dam_service.dtos.requests.damtypes.CreateDamTypeReqDTO;
import ctu.cit.se.dam_service.dtos.requests.damtypes.UpdateDamTypeReqDTO;
import ctu.cit.se.dam_service.dtos.responses.dams.RetrieveDamResDTO;
import ctu.cit.se.dam_service.dtos.responses.damtypes.RetrieveDamTypeResDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class DamTypeApplication implements IDamTypeApplication {
    @Autowired
    private IDamTypeDAO damTypeDAO;

    @Override
    public void create(CreateDamTypeReqDTO createDamTypeReqDTO) {
        damTypeDAO.create(createDamTypeReqDTO);
    }

    @Override
    public void update(UpdateDamTypeReqDTO updateDamTypeReqDTO) {
        damTypeDAO.update(updateDamTypeReqDTO);
    }

    @Override
    public List<RetrieveDamTypeResDTO> list() {
        return damTypeDAO.list();
    }

    @Override
    public RetrieveDamTypeResDTO retrieve(UUID damTypeId) {
        return damTypeDAO.retrieve(damTypeId);
    }

    @Override
    public void delete(UUID damTypeId) {
        damTypeDAO.delete(damTypeId);
    }
}
