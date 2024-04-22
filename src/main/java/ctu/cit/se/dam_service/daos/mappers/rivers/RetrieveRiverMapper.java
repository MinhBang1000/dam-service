package ctu.cit.se.dam_service.daos.mappers.rivers;

import ctu.cit.se.dam_service.daos.mappers.IMapper;
import ctu.cit.se.dam_service.dtos.responses.rivers.RetrieveRiverResDTO;
import ctu.cit.se.dam_service.entites.River;
import org.springframework.stereotype.Component;

@Component
public class RetrieveRiverMapper implements IMapper<River, RetrieveRiverResDTO> {
    @Override
    public RetrieveRiverResDTO convert(River source) {
        return RetrieveRiverResDTO.builder()
                .id(source.getId().toString())
                .name(source.getName())
                .code(source.getCode())
                .location(source.getLocation())
                .latitude(source.getLatitude())
                .longitude(source.getLongitude())
                .build();
    }
}
