package ctu.cit.se.dam_service.daos.mappers.damtypes;

import ctu.cit.se.dam_service.daos.mappers.IMapper;
import ctu.cit.se.dam_service.dtos.requests.damtypes.CreateDamTypeReqDTO;
import ctu.cit.se.dam_service.dtos.requests.rivers.CreateRiverReqDTO;
import ctu.cit.se.dam_service.entites.DamType;
import ctu.cit.se.dam_service.entites.River;
import org.springframework.stereotype.Component;

@Component
public class CreateDamTypeMapper implements IMapper<CreateDamTypeReqDTO, DamType> {
    @Override
    public DamType convert(CreateDamTypeReqDTO source) {
        return DamType.builder()
                .name(source.getName())
                .description(source.getDescription())
                .build();
    }
}
