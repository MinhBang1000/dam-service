package ctu.cit.se.dam_service.applications.impls;

import ctu.cit.se.dam_service.applications.specs.IDamStatusApplication;
import ctu.cit.se.dam_service.daos.specs.IDamStatusDAO;
import ctu.cit.se.dam_service.dtos.requests.damstatuses.CreateDamStatusReqDTO;
import ctu.cit.se.dam_service.dtos.requests.damstatuses.UpdateDamStatusReqDTO;
import ctu.cit.se.dam_service.dtos.responses.damstatuses.RetrieveDamStatusResDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class DamStatusApplication implements IDamStatusApplication {
    @Autowired
    private IDamStatusDAO damStatusDAO;

    @Override
    public void create(CreateDamStatusReqDTO createDamStatusReqDTO) {
        damStatusDAO.create(createDamStatusReqDTO);
    }

    @Override
    public void update(UpdateDamStatusReqDTO updateDamStatusReqDTO) {
        damStatusDAO.update(updateDamStatusReqDTO);
    }

    @Override
    public List<RetrieveDamStatusResDTO> list() {
        return damStatusDAO.list();
    }

    @Override
    public RetrieveDamStatusResDTO retrieve(UUID damStatusId) {
        return damStatusDAO.retrieve(damStatusId);
    }

    @Override
    public void delete(UUID damStatusId) {
        damStatusDAO.delete(damStatusId);
    }
}
