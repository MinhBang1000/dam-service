package ctu.cit.se.dam_service.daos.mappers.damtypes;

import ctu.cit.se.dam_service.daos.mappers.IMapper;
import ctu.cit.se.dam_service.dtos.requests.damtypes.UpdateDamTypeReqDTO;
import ctu.cit.se.dam_service.entites.DamType;
import ctu.cit.se.dam_service.exceptions.messages.CustomExceptionMessage;
import ctu.cit.se.dam_service.repositories.IDamTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

@Component
public class UpdateDamTypeMapper implements IMapper<UpdateDamTypeReqDTO, DamType> {
    @Autowired
    private IDamTypeRepository damTypeRepository;

    @Override
    public DamType convert(UpdateDamTypeReqDTO source) {
        var damType = damTypeRepository.findById(UUID.fromString(source.getId())).orElseThrow(() -> new IllegalArgumentException(CustomExceptionMessage.DAM_TYPE_NOT_FOUND_BY_ID));
        return DamType.builder()
                .code("normal")
                .id(damType.getId())
                .name(Objects.isNull(source.getName()) ? damType.getName() : source.getName())
                .description(Objects.isNull(source.getDescription()) ? damType.getDescription() : source.getDescription())
                .build();
    }
}
