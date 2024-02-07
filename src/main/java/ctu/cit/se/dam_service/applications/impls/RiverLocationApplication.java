package ctu.cit.se.dam_service.applications.impls;

import ctu.cit.se.dam_service.applications.specs.IRiverLocationApplication;
import ctu.cit.se.dam_service.daos.specs.IDamLocationDAO;
import ctu.cit.se.dam_service.daos.specs.IRiverLocationDAO;
import ctu.cit.se.dam_service.dtos.requests.riverlocations.CreateRiverLocationReqDTO;
import ctu.cit.se.dam_service.dtos.requests.riverlocations.UpdateRiverLocationReqDTO;
import ctu.cit.se.dam_service.dtos.responses.commands.CommandResDTO;
import ctu.cit.se.dam_service.dtos.responses.riverlocations.RetrieveRiverLocationResDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class RiverLocationApplication implements IRiverLocationApplication {
    @Autowired
    private IRiverLocationDAO riverLocationDAO;
    @Override
    public CommandResDTO create(CreateRiverLocationReqDTO createRiverLocationReqDTO) {
        return riverLocationDAO.create(createRiverLocationReqDTO);
    }

    @Override
    public CommandResDTO update(UpdateRiverLocationReqDTO updateRiverLocationReqDTO) {
        return riverLocationDAO.update(updateRiverLocationReqDTO);
    }

    @Override
    public List<RetrieveRiverLocationResDTO> list() {
        return riverLocationDAO.list();
    }

    @Override
    public RetrieveRiverLocationResDTO retrieve(UUID riverLocationId) {
        return riverLocationDAO.retrieve(riverLocationId);
    }

    @Override
    public void delete(UUID riverLocationId) {
        riverLocationDAO.delete(riverLocationId);
    }
}
