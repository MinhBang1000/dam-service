package ctu.cit.se.dam_service.daos.mappers.damstatuses;

import ctu.cit.se.dam_service.daos.mappers.IMapper;
import ctu.cit.se.dam_service.dtos.requests.dams.CreateDamReqDTO;
import ctu.cit.se.dam_service.dtos.requests.damstatuses.CreateDamStatusReqDTO;
import ctu.cit.se.dam_service.entites.Dam;
import ctu.cit.se.dam_service.entites.DamStatus;
import ctu.cit.se.dam_service.exceptions.messages.CustomExceptionMessage;
import ctu.cit.se.dam_service.repositories.IDamTypeRepository;
import ctu.cit.se.dam_service.repositories.IRiverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateDamStatusMapper implements IMapper<CreateDamStatusReqDTO, DamStatus> {
    @Override
    public DamStatus convert(CreateDamStatusReqDTO source) {
        return DamStatus.builder().name(source.getName()).build();
    }
}
