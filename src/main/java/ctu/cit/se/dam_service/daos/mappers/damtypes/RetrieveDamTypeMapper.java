package ctu.cit.se.dam_service.daos.mappers.damtypes;

import ctu.cit.se.dam_service.daos.mappers.IMapper;
import ctu.cit.se.dam_service.dtos.responses.damtypes.RetrieveDamTypeResDTO;
import ctu.cit.se.dam_service.entites.DamType;
import org.springframework.stereotype.Component;

@Component
public class RetrieveDamTypeMapper implements IMapper<DamType, RetrieveDamTypeResDTO> {
    @Override
    public RetrieveDamTypeResDTO convert(DamType source) {
        return RetrieveDamTypeResDTO.builder()
                .id(source.getId().toString())
                .name(source.getName())
                .code(source.getCode())
                .description(source.getDescription())
                .build();
    }
}
