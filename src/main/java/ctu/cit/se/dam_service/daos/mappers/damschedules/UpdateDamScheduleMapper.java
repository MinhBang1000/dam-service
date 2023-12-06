package ctu.cit.se.dam_service.daos.mappers.damschedules;

import ctu.cit.se.dam_service.daos.mappers.IMapper;
import ctu.cit.se.dam_service.dtos.requests.damschedules.UpdateDamScheduleReqDTO;
import ctu.cit.se.dam_service.dtos.requests.damstatuses.UpdateDamStatusReqDTO;
import ctu.cit.se.dam_service.entites.DamSchedule;
import ctu.cit.se.dam_service.entites.DamStatus;
import ctu.cit.se.dam_service.exceptions.messages.CustomExceptionMessage;
import ctu.cit.se.dam_service.repositories.IDamRepository;
import ctu.cit.se.dam_service.repositories.IDamScheduleRepository;
import ctu.cit.se.dam_service.repositories.IDamStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

@Component
public class UpdateDamScheduleMapper implements IMapper<UpdateDamScheduleReqDTO, DamSchedule> {
    @Autowired
    private IDamStatusRepository damStatusRepository;
    @Autowired
    private IDamScheduleRepository damScheduleRepository;

    @Override
    public DamSchedule convert(UpdateDamScheduleReqDTO source) {
        var damSchedule = damScheduleRepository.findById(UUID.fromString(source.getId())).orElseThrow(() -> new IllegalArgumentException(CustomExceptionMessage.DAM_SCHEDULE_NOT_FOUND_BY_ID));
        var damStatus = damStatusRepository.findById(UUID.fromString(source.getDamStatusId())).orElseThrow(() -> new IllegalArgumentException(CustomExceptionMessage.DAM_STATUS_NOT_FOUND_BY_ID));
        return DamSchedule.builder()
                .damStatus(Objects.isNull(source.getDamStatusId()) ? damStatus : damSchedule.getDamStatus())
                .id(damSchedule.getId())
                .beginAt(Objects.isNull(source.getBeginAt()) ? damSchedule.getBeginAt() : source.getBeginAt())
                .endAt(Objects.isNull(source.getEndAt()) ? damSchedule.getEndAt() : source.getEndAt())
                .description(Objects.isNull(source.getDescription()) ? damSchedule.getDescription() : source.getDescription())
                .build();
    }
}
