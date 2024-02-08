package ctu.cit.se.dam_service.daos.mappers.damschedules;

import ctu.cit.se.dam_service.daos.mappers.IMapper;
import ctu.cit.se.dam_service.dtos.requests.damschedules.CreateDamScheduleReqDTO;
import ctu.cit.se.dam_service.dtos.requests.damstatuses.CreateDamStatusReqDTO;
import ctu.cit.se.dam_service.entites.DamSchedule;
import ctu.cit.se.dam_service.entites.DamStatus;
import ctu.cit.se.dam_service.exceptions.messages.CustomExceptionMessage;
import ctu.cit.se.dam_service.repositories.IDamRepository;
import ctu.cit.se.dam_service.repositories.IDamStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

@Component
public class CreateDamScheduleMapper implements IMapper<CreateDamScheduleReqDTO, DamSchedule> {
    @Autowired
    private IDamRepository damRepository;
    @Autowired
    private IDamStatusRepository damStatusRepository;

    @Override
    public DamSchedule convert(CreateDamScheduleReqDTO source) {
        var dam = damRepository.findById(UUID.fromString(source.getDamId())).orElseThrow(() -> new IllegalArgumentException(CustomExceptionMessage.DAM_NOT_FOUND_BY_ID));
        DamStatus damStatus = DamStatus.builder().build();
        if (Objects.isNull(source.getDamStatusId())) {
            try {
                DamStatus existedDamStatus = damStatusRepository.findByName("OPEN").get();
                damStatus = existedDamStatus;
            }catch (Exception ex) {
                damStatus.setName("OPEN");
                damStatus = damStatusRepository.save(damStatus);
            }
        }else {
            damStatus = damStatusRepository.findById(UUID.fromString(source.getDamStatusId())).orElseThrow(() -> new IllegalArgumentException(CustomExceptionMessage.DAM_STATUS_NOT_FOUND_BY_ID));
        }
        return DamSchedule.builder()
                .dam(dam)
                .damStatus(damStatus)
                .description(source.getDescription())
                .beginAt(source.getBeginAt())
                .endAt(source.getEndAt())
                .isLock(source.getIsLock())
                .build();
    }
}
