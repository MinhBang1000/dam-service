package ctu.cit.se.dam_service.daos.mappers.riverlocations;

import ctu.cit.se.dam_service.daos.mappers.IMapper;
import ctu.cit.se.dam_service.dtos.responses.damtypes.RetrieveDamTypeResDTO;
import ctu.cit.se.dam_service.dtos.responses.riverlocations.RetrieveRiverLocationResDTO;
import ctu.cit.se.dam_service.dtos.responses.rivers.RetrieveRiverResDTO;
import ctu.cit.se.dam_service.entites.DamType;
import ctu.cit.se.dam_service.entites.River;
import ctu.cit.se.dam_service.entites.RiverLocation;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RetrieveRiverLocationMapper implements IMapper<RiverLocation, RetrieveRiverLocationResDTO> {
    @Autowired
    private IMapper<River, RetrieveRiverResDTO> riverMapper;

    @Override
    public RetrieveRiverLocationResDTO convert(RiverLocation source) {
        return RetrieveRiverLocationResDTO.builder()
                .id(source.getId().toString())
                .longitude(source.getLongitude())
                .latitude(source.getLatitude())
                .river(riverMapper.convert(source.getRiver()))
                .build();
    }
}
