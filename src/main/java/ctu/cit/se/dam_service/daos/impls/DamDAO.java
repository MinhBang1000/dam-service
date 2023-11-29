package ctu.cit.se.dam_service.daos.impls;

import ctu.cit.se.dam_service.daos.specs.IDamDAO;
import ctu.cit.se.dam_service.dtos.requests.dams.CreateDamReqDTO;
import ctu.cit.se.dam_service.dtos.requests.dams.UpdateDamReqDTO;
import ctu.cit.se.dam_service.dtos.responses.dams.RetrieveDamResDTO;

import java.util.List;
import java.util.UUID;

public class DamDAO implements IDamDAO {
    @Override
    public void create(CreateDamReqDTO createDamReqDTO) {

    }

    @Override
    public void update(UpdateDamReqDTO updateDamReqDTO) {

    }

    @Override
    public List<RetrieveDamResDTO> list() {
        return null;
    }

    @Override
    public RetrieveDamResDTO retrieve(UUID damId) {
        return null;
    }

    @Override
    public void delete(UUID damId) {

    }
}
