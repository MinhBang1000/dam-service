package ctu.cit.se.dam_service.daos.mappers.damschedules;

import ctu.cit.se.dam_service.daos.mappers.IMapper;
import ctu.cit.se.dam_service.dtos.responses.damschedules.RetrieveDamScheduleShorterVersionResDTO;
import ctu.cit.se.dam_service.entites.DamSchedule;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RetrieveDamScheduleShorterVersionMapper implements IMapper<DamSchedule, RetrieveDamScheduleShorterVersionResDTO> {
    @Override
    public RetrieveDamScheduleShorterVersionResDTO convert(DamSchedule source) {
        return RetrieveDamScheduleShorterVersionResDTO.builder()
                .id(source.getId().toString())
                .beginAt(source.getBeginAt())
                .endAt(source.getEndAt())
                .build();
    }
}
