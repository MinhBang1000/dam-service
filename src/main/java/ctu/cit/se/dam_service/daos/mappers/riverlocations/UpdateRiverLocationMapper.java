package ctu.cit.se.dam_service.daos.mappers.riverlocations;

import ctu.cit.se.dam_service.daos.mappers.IMapper;
import ctu.cit.se.dam_service.dtos.requests.damtypes.UpdateDamTypeReqDTO;
import ctu.cit.se.dam_service.dtos.requests.riverlocations.UpdateRiverLocationReqDTO;
import ctu.cit.se.dam_service.entites.DamType;
import ctu.cit.se.dam_service.entites.RiverLocation;
import ctu.cit.se.dam_service.exceptions.messages.CustomExceptionMessage;
import ctu.cit.se.dam_service.repositories.IDamTypeRepository;
import ctu.cit.se.dam_service.repositories.IRiverLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

@Component
public class UpdateRiverLocationMapper implements IMapper<UpdateRiverLocationReqDTO, RiverLocation> {
    @Autowired
    private IRiverLocationRepository riverLocationRepository;

    @Override
    public RiverLocation convert(UpdateRiverLocationReqDTO source) {
        var riverLocation = riverLocationRepository.findById(UUID.fromString(source.getId())).orElseThrow(() -> new IllegalArgumentException(CustomExceptionMessage.RIVER_LOCATION_NOT_FOUND_BY_ID));
        return RiverLocation.builder()
                .id(riverLocation.getId())
                .longitude(Objects.isNull(source.getLongitude()) ? riverLocation.getLongitude() : source.getLongitude())
                .latitude(Objects.isNull(source.getLatitude()) ? riverLocation.getLatitude() : source.getLatitude())
                .river(riverLocation.getRiver())
                .build();
    }
}
