package ctu.cit.se.dam_service.applications.impls;

import ctu.cit.se.dam_service.applications.specs.IDamApplication;
import ctu.cit.se.dam_service.applications.specs.IRiverApplication;
import ctu.cit.se.dam_service.daos.specs.IDamDAO;
import ctu.cit.se.dam_service.daos.specs.IRiverDAO;
import ctu.cit.se.dam_service.dtos.requests.dams.CreateDamReqDTO;
import ctu.cit.se.dam_service.dtos.requests.dams.UpdateDamReqDTO;
import ctu.cit.se.dam_service.dtos.requests.rivers.CreateRiverReqDTO;
import ctu.cit.se.dam_service.dtos.requests.rivers.UpdateRiverReqDTO;
import ctu.cit.se.dam_service.dtos.responses.dams.RetrieveDamResDTO;
import ctu.cit.se.dam_service.dtos.responses.rivers.RetrieveRiverResDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class RiverApplication implements IRiverApplication {
    @Autowired
    private IRiverDAO riverDAO;

    @Override
    public void create(CreateRiverReqDTO createRiverReqDTO) {
        riverDAO.create(createRiverReqDTO);
    }

    @Override
    public void update(UpdateRiverReqDTO updateRiverReqDTO) {
        riverDAO.update(updateRiverReqDTO);
    }

    @Override
    public List<RetrieveRiverResDTO> list() {
        return riverDAO.list();
    }

    @Override
    public RetrieveRiverResDTO retrieve(UUID riverId) {
        return riverDAO.retrieve(riverId);
    }

    @Override
    public void delete(UUID riverId) {
        riverDAO.delete(riverId);
    }
}
