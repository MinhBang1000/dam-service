package ctu.cit.se.dam_service.applications.impls;

import ctu.cit.se.dam_service.applications.specs.IDamScheduleApplication;
import ctu.cit.se.dam_service.daos.specs.IDamScheduleDAO;
import ctu.cit.se.dam_service.dtos.requests.damschedules.CreateDamScheduleReqDTO;
import ctu.cit.se.dam_service.dtos.requests.damschedules.UpdateDamScheduleReqDTO;
import ctu.cit.se.dam_service.dtos.responses.damschedules.RetrieveDamScheduleResDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class DamScheduleApplication implements IDamScheduleApplication {
    @Autowired
    private IDamScheduleDAO damScheduleDAO;

    @Override
    public void create(CreateDamScheduleReqDTO createDamScheduleReqDTO) {
        damScheduleDAO.create(createDamScheduleReqDTO);
    }

    @Override
    public void update(UpdateDamScheduleReqDTO updateDamScheduleReqDTO) {
        damScheduleDAO.update(updateDamScheduleReqDTO);
    }

    @Override
    public List<RetrieveDamScheduleResDTO> list() {
        return damScheduleDAO.list();
    }

    @Override
    public RetrieveDamScheduleResDTO retrieve(UUID damScheduleId) {
        return damScheduleDAO.retrieve(damScheduleId);
    }

    @Override
    public void delete(UUID damScheduleId) {
        damScheduleDAO.delete(damScheduleId);
    }
}
