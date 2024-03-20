package ctu.cit.se.dam_service.daos.mappers.damschedules;

import ctu.cit.se.dam_service.daos.mappers.IMapper;
import ctu.cit.se.dam_service.dtos.responses.damschedules.RetrieveDamScheduleBySelectedDateResDTO;
import ctu.cit.se.dam_service.entites.Dam;
import org.springframework.stereotype.Component;

@Component
public class RetrieveDamScheduleBySelectedDateMapper implements IMapper<Dam, RetrieveDamScheduleBySelectedDateResDTO> {
    @Override
    public RetrieveDamScheduleBySelectedDateResDTO convert(Dam source) {
        return RetrieveDamScheduleBySelectedDateResDTO.builder()
                .id(source.getId().toString())
                .name(source.getName())
                .longitude(source.getLongitude())
                .latitude(source.getLatitude())
                .capacity(source.getCapacity())
                .height(source.getHeight())
                .riverName(source.getRiver().getName())
                .description(source.getDescription())
                .build();
    }
}
