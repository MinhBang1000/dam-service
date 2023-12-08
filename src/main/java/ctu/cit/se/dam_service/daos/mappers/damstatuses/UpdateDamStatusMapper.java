package ctu.cit.se.dam_service.daos.mappers.damstatuses;

import ctu.cit.se.dam_service.daos.mappers.IMapper;
import ctu.cit.se.dam_service.dtos.requests.dams.UpdateDamReqDTO;
import ctu.cit.se.dam_service.dtos.requests.damstatuses.UpdateDamStatusReqDTO;
import ctu.cit.se.dam_service.entites.Dam;
import ctu.cit.se.dam_service.entites.DamStatus;
import ctu.cit.se.dam_service.exceptions.messages.CustomExceptionMessage;
import ctu.cit.se.dam_service.repositories.IDamRepository;
import ctu.cit.se.dam_service.repositories.IDamStatusRepository;
import ctu.cit.se.dam_service.repositories.IDamTypeRepository;
import ctu.cit.se.dam_service.repositories.IRiverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

@Component
public class UpdateDamStatusMapper implements IMapper<UpdateDamStatusReqDTO, DamStatus> {
    @Autowired
    private IDamStatusRepository damStatusRepository;
    @Override
    public DamStatus convert(UpdateDamStatusReqDTO source) {
        var damStatus = damStatusRepository.findById(UUID.fromString(source.getId())).orElseThrow(() -> new IllegalArgumentException(CustomExceptionMessage.DAM_STATUS_NOT_FOUND_BY_ID));
        return DamStatus.builder().id(UUID.fromString(source.getId())).name(Objects.isNull(source.getName()) ? damStatus.getName() : source.getName()).build();
    }
}
