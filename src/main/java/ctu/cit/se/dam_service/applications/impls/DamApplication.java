package ctu.cit.se.dam_service.applications.impls;

import ctu.cit.se.dam_service.applications.specs.IDamApplication;
import ctu.cit.se.dam_service.daos.specs.IDamDAO;
import ctu.cit.se.dam_service.dtos.requests.dams.CreateDamReqDTO;
import ctu.cit.se.dam_service.dtos.requests.dams.UpdateDamReqDTO;
import ctu.cit.se.dam_service.dtos.responses.dams.RetrieveDamResDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class DamApplication implements IDamApplication {
    @Autowired
    private IDamDAO damDAO;

    @Override
    public void create(CreateDamReqDTO createDamReqDTO) {
        damDAO.create(createDamReqDTO);
    }

    @Override
    public void update(UpdateDamReqDTO updateDamReqDTO) {
        damDAO.update(updateDamReqDTO);
    }

    @Override
    public List<RetrieveDamResDTO> list() {
        return damDAO.list();
    }

    @Override
    public RetrieveDamResDTO retrieve(UUID damId) {
        return damDAO.retrieve(damId);
    }

    @Override
    public void delete(UUID damId) {
        damDAO.delete(damId);
    }
}
