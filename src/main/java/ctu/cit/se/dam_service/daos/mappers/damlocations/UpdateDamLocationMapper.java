package ctu.cit.se.dam_service.daos.mappers.damlocations;

import ctu.cit.se.dam_service.daos.mappers.IMapper;
import ctu.cit.se.dam_service.dtos.requests.damlocations.UpdateDamLocationReqDTO;
import ctu.cit.se.dam_service.dtos.requests.riverlocations.UpdateRiverLocationReqDTO;
import ctu.cit.se.dam_service.entites.DamLocation;
import ctu.cit.se.dam_service.entites.RiverLocation;
import ctu.cit.se.dam_service.exceptions.messages.CustomExceptionMessage;
import ctu.cit.se.dam_service.repositories.IDamLocationRepository;
import ctu.cit.se.dam_service.repositories.IRiverLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

@Component
public class UpdateDamLocationMapper implements IMapper<UpdateDamLocationReqDTO, DamLocation> {
    @Autowired
    private IDamLocationRepository damLocationRepository;

    @Override
    public DamLocation convert(UpdateDamLocationReqDTO source) {
        var damLocation = damLocationRepository.findById(UUID.fromString(source.getId())).orElseThrow(() -> new IllegalArgumentException(CustomExceptionMessage.DAM_LOCATION_NOT_FOUND_BY_ID));
        return DamLocation.builder()
                .id(damLocation.getId())
                .longitude(Objects.isNull(source.getLongitude()) ? damLocation.getLongitude() : source.getLongitude())
                .latitude(Objects.isNull(source.getLatitude()) ? damLocation.getLatitude() : source.getLatitude())
                .dam(damLocation.getDam())
                .build();
    }
}
