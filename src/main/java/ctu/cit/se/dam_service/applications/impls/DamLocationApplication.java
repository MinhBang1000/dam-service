package ctu.cit.se.dam_service.applications.impls;

import ctu.cit.se.dam_service.applications.specs.IDamLocationApplication;
import ctu.cit.se.dam_service.daos.specs.IDamLocationDAO;
import ctu.cit.se.dam_service.dtos.requests.damlocations.CreateDamLocationReqDTO;
import ctu.cit.se.dam_service.dtos.requests.damlocations.UpdateDamLocationReqDTO;
import ctu.cit.se.dam_service.dtos.responses.commands.CommandResDTO;
import ctu.cit.se.dam_service.dtos.responses.damlocations.RetrieveDamLocationResDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class DamLocationApplication implements IDamLocationApplication {
    @Autowired
    private IDamLocationDAO damLocationDAO;

    @Override
    public CommandResDTO create(CreateDamLocationReqDTO createDamLocationReqDTO) {
        return damLocationDAO.create(createDamLocationReqDTO);
    }

    @Override
    public CommandResDTO update(UpdateDamLocationReqDTO updateDamLocationReqDTO) {
        return damLocationDAO.update(updateDamLocationReqDTO);
    }

    @Override
    public List<RetrieveDamLocationResDTO> list() {
        return damLocationDAO.list();
    }

    @Override
    public RetrieveDamLocationResDTO retrieve(UUID damLocationId) {
        return damLocationDAO.retrieve(damLocationId);
    }

    @Override
    public void delete(UUID damLocationId) {
        damLocationDAO.delete(damLocationId);
    }
}
