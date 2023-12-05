package ctu.cit.se.dam_service.daos.mappers.damstatuses;

import ctu.cit.se.dam_service.daos.mappers.IMapper;
import ctu.cit.se.dam_service.dtos.responses.dams.RetrieveDamResDTO;
import ctu.cit.se.dam_service.dtos.responses.damstatuses.RetrieveDamStatusResDTO;
import ctu.cit.se.dam_service.dtos.responses.damtypes.RetrieveDamTypeResDTO;
import ctu.cit.se.dam_service.dtos.responses.rivers.RetrieveRiverResDTO;
import ctu.cit.se.dam_service.entites.Dam;
import ctu.cit.se.dam_service.entites.DamStatus;
import ctu.cit.se.dam_service.entites.DamType;
import ctu.cit.se.dam_service.entites.River;
import ctu.cit.se.dam_service.repositories.IDamTypeRepository;
import ctu.cit.se.dam_service.repositories.IRiverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RetrieveDamStatusMapper implements IMapper<DamStatus, RetrieveDamStatusResDTO> {
    @Override
    public RetrieveDamStatusResDTO convert(DamStatus source) {
        return RetrieveDamStatusResDTO.builder()
                .id(source.getName())
                .name(source.getName())
                .build();
    }
}
