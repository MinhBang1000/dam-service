package ctu.cit.se.dam_service.daos.mappers.dams;

import ctu.cit.se.dam_service.daos.mappers.IMapper;
import ctu.cit.se.dam_service.dtos.responses.dams.RetrieveDamResDTO;
import ctu.cit.se.dam_service.dtos.responses.damstatuses.RetrieveDamStatusResDTO;
import ctu.cit.se.dam_service.dtos.responses.damtypes.RetrieveDamTypeResDTO;
import ctu.cit.se.dam_service.dtos.responses.rivers.RetrieveRiverResDTO;
import ctu.cit.se.dam_service.entites.Dam;
import ctu.cit.se.dam_service.entites.DamStatus;
import ctu.cit.se.dam_service.entites.DamType;
import ctu.cit.se.dam_service.entites.River;
import ctu.cit.se.dam_service.exceptions.messages.CustomExceptionMessage;
import ctu.cit.se.dam_service.repositories.IDamScheduleRepository;
import ctu.cit.se.dam_service.repositories.IDamStatusRepository;
import ctu.cit.se.dam_service.repositories.IDamTypeRepository;
import ctu.cit.se.dam_service.repositories.IRiverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Component
public class RetrieveDamMapper implements IMapper<Dam, RetrieveDamResDTO> {
    @Autowired
    private IDamTypeRepository damTypeRepository;
    @Autowired
    private IRiverRepository riverRepository;
    @Autowired
    private IDamStatusRepository damStatusRepository;
    @Autowired
    private IDamScheduleRepository damScheduleRepository;
    @Autowired
    private IMapper<DamType, RetrieveDamTypeResDTO> damTypeMapper;
    @Autowired
    private IMapper<River, RetrieveRiverResDTO> riverMapper;
    @Autowired
    private IMapper<DamStatus, RetrieveDamStatusResDTO> damStatusMapper;

    @Override
    public RetrieveDamResDTO convert(Dam source) {
        var now = LocalDateTime.now();
        Boolean openStatus = false;
        DamStatus damStatus = DamStatus.builder().name("CLOSE").build();
        var damSchedules = damScheduleRepository.findAllByDamIdAndIsLock(source.getId(),false);
        /* Retrieve Dam Current Status */
        if (damSchedules.stream().filter(damSchedule -> damSchedule.getBeginAt().isBefore(now) && damSchedule.getEndAt().isAfter(now)).collect(Collectors.toList()).isEmpty()) {
            openStatus = true;
        }
        if (openStatus) {
            try {
                var damOpenStatus = damStatusRepository.findByName("OPEN").get();
                damStatus = damOpenStatus;
            }catch (Exception ex) {
                damStatus.setName("OPEN");
                var damOpenStatus = damStatusRepository.save(damStatus);
                damStatus = damOpenStatus;
            }
        }else {
            try {
                var damCloseStatus = damStatusRepository.findByName("CLOSE").get();
                damStatus = damCloseStatus;
            }catch (Exception ex) {
                var damCloseStatus = damStatusRepository.save(damStatus);
                damStatus = damCloseStatus;
            }
        }
        return RetrieveDamResDTO.builder()
                .id(source.getId().toString())
                .name(source.getName())
                .capacity(source.getCapacity())
                .constructedAt(source.getConstructedAt())
                .height(source.getHeight())
                .longitude(source.getLongitude())
                .latitude(source.getLatitude())
                .description(source.getDescription())
                .river(riverMapper.convert(source.getRiver()))
                .damType(damTypeMapper.convert(source.getDamType()))
                .damStatus(damStatusMapper.convert(damStatus))
                .build();
    }
}
