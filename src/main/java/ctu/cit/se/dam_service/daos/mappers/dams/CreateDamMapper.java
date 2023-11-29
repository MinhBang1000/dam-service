package ctu.cit.se.dam_service.daos.mappers.dams;

import ctu.cit.se.dam_service.daos.mappers.IMapper;
import ctu.cit.se.dam_service.dtos.requests.dams.CreateDamReqDTO;
import ctu.cit.se.dam_service.entites.Dam;
import ctu.cit.se.dam_service.exceptions.messages.CustomExceptionMessage;
import ctu.cit.se.dam_service.repositories.IDamTypeRepository;
import ctu.cit.se.dam_service.repositories.IRiverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateDamMapper implements IMapper<CreateDamReqDTO, Dam> {
    @Autowired
    private IDamTypeRepository damTypeRepository;
    @Autowired
    private IRiverRepository riverRepository;
    @Override
    public Dam convert(CreateDamReqDTO source) {
        var river = riverRepository.findById(UUID.fromString(source.getRiverId())).orElseThrow(() -> new IllegalArgumentException(CustomExceptionMessage.RIVER_NOT_FOUND_BY_ID));
        var damType = damTypeRepository.findById(UUID.fromString(source.getDamTypeId())).orElseThrow(() -> new IllegalArgumentException(CustomExceptionMessage.DAM_TYPE_NOT_FOUND_BY_ID));
        return Dam.builder()
                .name(source.getName())
                .constructedAt(source.getConstructedAt())
                .height(source.getHeight())
                .damType(damType)
                .river(river)
                .capacity(source.getCapacity())
                .longtitude(source.getLongtitude())
                .latitude(source.getLatitude())
                .build();
    }
}
