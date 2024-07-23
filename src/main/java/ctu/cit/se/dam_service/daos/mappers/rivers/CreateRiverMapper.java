package ctu.cit.se.dam_service.daos.mappers.rivers;

import ctu.cit.se.dam_service.daos.mappers.IMapper;
import ctu.cit.se.dam_service.dtos.requests.rivers.CreateRiverReqDTO;
import ctu.cit.se.dam_service.entites.River;
import org.springframework.stereotype.Component;

@Component
public class CreateRiverMapper implements IMapper<CreateRiverReqDTO, River> {
    @Override
    public River convert(CreateRiverReqDTO source) {
        return River.builder()
                .name(source.getName())
                .location(source.getLocation())
                .latitude(source.getLatitude())
                .longitude(source.getLongitude())
                .length(source.getLength())
                .width(source.getWidth())
                .level(source.getLevel())
                .nearestProcessingAt(source.getNearestProcessingAt())
                .address(source.getAddress())
                .build();
    }
}
