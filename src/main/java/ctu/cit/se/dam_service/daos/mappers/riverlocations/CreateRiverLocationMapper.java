package ctu.cit.se.dam_service.daos.mappers.riverlocations;

import ctu.cit.se.dam_service.daos.mappers.IMapper;
import ctu.cit.se.dam_service.dtos.requests.damtypes.CreateDamTypeReqDTO;
import ctu.cit.se.dam_service.dtos.requests.riverlocations.CreateRiverLocationReqDTO;
import ctu.cit.se.dam_service.entites.DamType;
import ctu.cit.se.dam_service.entites.RiverLocation;
import ctu.cit.se.dam_service.exceptions.messages.CustomExceptionMessage;
import ctu.cit.se.dam_service.repositories.IRiverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateRiverLocationMapper implements IMapper<CreateRiverLocationReqDTO, RiverLocation> {
    @Autowired
    private IRiverRepository riverRepository;

    @Override
    public RiverLocation convert(CreateRiverLocationReqDTO source) {
        var river = riverRepository.findById(UUID.fromString(source.getRiverId())).orElseThrow(() -> new IllegalArgumentException(CustomExceptionMessage.RIVER_NOT_FOUND_BY_ID));
        return RiverLocation.builder()
                .river(river)
                .longitude(source.getLongitude())
                .latitude(source.getLatitude())
                .build();
    }
}
