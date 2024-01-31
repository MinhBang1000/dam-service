package ctu.cit.se.dam_service.daos.mappers.damlocations;

import ctu.cit.se.dam_service.daos.mappers.IMapper;
import ctu.cit.se.dam_service.dtos.responses.damlocations.RetrieveDamLocationResDTO;
import ctu.cit.se.dam_service.dtos.responses.dams.RetrieveDamResDTO;
import ctu.cit.se.dam_service.dtos.responses.riverlocations.RetrieveRiverLocationResDTO;
import ctu.cit.se.dam_service.dtos.responses.rivers.RetrieveRiverResDTO;
import ctu.cit.se.dam_service.entites.Dam;
import ctu.cit.se.dam_service.entites.DamLocation;
import ctu.cit.se.dam_service.entites.River;
import ctu.cit.se.dam_service.entites.RiverLocation;
import ctu.cit.se.dam_service.repositories.IDamLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RetrieveDamLocationMapper implements IMapper<DamLocation, RetrieveDamLocationResDTO> {
    @Autowired
    private IMapper<Dam, RetrieveDamResDTO> damMapper;

    @Override
    public RetrieveDamLocationResDTO convert(DamLocation source) {
        return RetrieveDamLocationResDTO.builder()
                .id(source.getId().toString())
                .longtitude(source.getLongitude())
                .latitude(source.getLatitude())
                .dam(damMapper.convert(source.getDam()))
                .build();
    }
}
