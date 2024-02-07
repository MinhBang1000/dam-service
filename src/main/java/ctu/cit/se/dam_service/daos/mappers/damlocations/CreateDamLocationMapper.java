package ctu.cit.se.dam_service.daos.mappers.damlocations;

import ctu.cit.se.dam_service.daos.mappers.IMapper;
import ctu.cit.se.dam_service.dtos.requests.damlocations.CreateDamLocationReqDTO;
import ctu.cit.se.dam_service.dtos.requests.riverlocations.CreateRiverLocationReqDTO;
import ctu.cit.se.dam_service.entites.DamLocation;
import ctu.cit.se.dam_service.entites.RiverLocation;
import ctu.cit.se.dam_service.exceptions.messages.CustomExceptionMessage;
import ctu.cit.se.dam_service.repositories.IDamRepository;
import ctu.cit.se.dam_service.repositories.IRiverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateDamLocationMapper implements IMapper<CreateDamLocationReqDTO, DamLocation> {
    @Autowired
    private IDamRepository damRepository;

    @Override
    public DamLocation convert(CreateDamLocationReqDTO source) {
        var dam = damRepository.findById(UUID.fromString(source.getDamId())).orElseThrow(() -> new IllegalArgumentException(CustomExceptionMessage.DAM_NOT_FOUND_BY_ID));
        return DamLocation.builder()
                .dam(dam)
                .longitude(source.getLongitude())
                .latitude(source.getLatitude())
                .build();
    }
}
