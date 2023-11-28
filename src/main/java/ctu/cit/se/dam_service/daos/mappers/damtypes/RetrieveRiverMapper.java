package ctu.cit.se.dam_service.daos.mappers.damtypes;

import ctu.cit.se.dam_service.daos.mappers.IMapper;
import ctu.cit.se.dam_service.dtos.responses.damtypes.RetrieveDamTypeResDTO;
import ctu.cit.se.dam_service.dtos.responses.rivers.RetrieveRiverResDTO;
import ctu.cit.se.dam_service.entites.DamType;
import ctu.cit.se.dam_service.entites.River;
import org.springframework.stereotype.Component;

@Component
public class RetrieveRiverMapper implements IMapper<DamType, RetrieveDamTypeResDTO> {
    @Override
    public RetrieveDamTypeResDTO convert(DamType source) {
        return RetrieveDamTypeResDTO.builder()
                .id(source.getId().toString())
                .name(source.getName())
                .description(source.getDescription())
                .build();
    }
}
