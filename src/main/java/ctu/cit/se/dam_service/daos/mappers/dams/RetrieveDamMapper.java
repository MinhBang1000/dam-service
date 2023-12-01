package ctu.cit.se.dam_service.daos.mappers.dams;

import ctu.cit.se.dam_service.daos.mappers.IMapper;
import ctu.cit.se.dam_service.dtos.responses.dams.RetrieveDamResDTO;
import ctu.cit.se.dam_service.dtos.responses.damtypes.RetrieveDamTypeResDTO;
import ctu.cit.se.dam_service.dtos.responses.rivers.RetrieveRiverResDTO;
import ctu.cit.se.dam_service.entites.Dam;
import ctu.cit.se.dam_service.entites.DamType;
import ctu.cit.se.dam_service.entites.River;
import ctu.cit.se.dam_service.repositories.IDamTypeRepository;
import ctu.cit.se.dam_service.repositories.IRiverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RetrieveDamMapper implements IMapper<Dam, RetrieveDamResDTO> {
    @Autowired
    private IDamTypeRepository damTypeRepository;
    @Autowired
    private IRiverRepository riverRepository;
    @Autowired
    private IMapper<DamType, RetrieveDamTypeResDTO> damTypeMapper;
    @Autowired
    private IMapper<River, RetrieveRiverResDTO> riverMapper;

    @Override
    public RetrieveDamResDTO convert(Dam source) {
        return RetrieveDamResDTO.builder()
                .id(source.getId().toString())
                .name(source.getName())
                .capacity(source.getCapacity())
                .isLock(source.getIsLock())
                .constructedAt(source.getConstructedAt())
                .height(source.getHeight())
                .longtitude(source.getLongtitude())
                .latitude(source.getLatitude())
                .river(riverMapper.convert(source.getRiver()))
                .damType(damTypeMapper.convert(source.getDamType()))
                .build();
    }
}
