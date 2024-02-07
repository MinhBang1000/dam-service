package ctu.cit.se.dam_service.daos.mappers.damschedules;

import ctu.cit.se.dam_service.daos.mappers.IMapper;
import ctu.cit.se.dam_service.dtos.responses.dams.RetrieveDamResDTO;
import ctu.cit.se.dam_service.dtos.responses.damschedules.RetrieveDamScheduleResDTO;
import ctu.cit.se.dam_service.dtos.responses.damstatuses.RetrieveDamStatusResDTO;
import ctu.cit.se.dam_service.entites.Dam;
import ctu.cit.se.dam_service.entites.DamSchedule;
import ctu.cit.se.dam_service.entites.DamStatus;
import ctu.cit.se.dam_service.repositories.IDamScheduleRepository;
import ctu.cit.se.dam_service.repositories.IDamStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RetrieveDamScheduleMapper implements IMapper<DamSchedule, RetrieveDamScheduleResDTO> {
    @Autowired
    private IMapper<Dam, RetrieveDamResDTO> damMapper;
    @Autowired
    private IMapper<DamStatus, RetrieveDamStatusResDTO> damStatusMapper;

    @Override
    public RetrieveDamScheduleResDTO convert(DamSchedule source) {
        return RetrieveDamScheduleResDTO.builder()
                .id(source.getId().toString())
                .dam(damMapper.convert(source.getDam()))
                .damStatus(damStatusMapper.convert(source.getDamStatus()))
                .beginAt(source.getBeginAt())
                .description(source.getDescription())
                .isLock(source.getIsLock())
                .endAt(source.getEndAt())
                .build();
    }
}
