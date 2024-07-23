package ctu.cit.se.dam_service.daos.mappers.rivers;

import ctu.cit.se.dam_service.daos.mappers.IMapper;
import ctu.cit.se.dam_service.dtos.requests.rivers.UpdateRiverReqDTO;
import ctu.cit.se.dam_service.entites.River;
import ctu.cit.se.dam_service.exceptions.messages.CustomExceptionMessage;
import ctu.cit.se.dam_service.repositories.IRiverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

@Component
public class UpdateRiverMapper implements IMapper<UpdateRiverReqDTO, River> {
    @Autowired
    private IRiverRepository riverRepository;

    @Override
    public River convert(UpdateRiverReqDTO source) {
        var river = riverRepository.findById(UUID.fromString(source.getId())).orElseThrow(() -> new IllegalArgumentException(CustomExceptionMessage.RIVER_NOT_FOUND_BY_ID));
        return River.builder()
                .id(river.getId())
                .name(Objects.isNull(source.getName()) ? river.getName() : source.getName())
                .location(Objects.isNull(source.getLocation()) ? river.getLocation() : source.getLocation())
                .latitude(Objects.isNull(source.getLatitude()) ? river.getLatitude() : source.getLatitude())
                .longitude(Objects.isNull(source.getLongitude()) ? river.getLongitude() : source.getLongitude())
                .address(Objects.isNull(source.getAddress()) ? river.getAddress() : source.getAddress())
                .level(Objects.isNull(source.getLevel()) ? river.getLevel() : source.getLevel())
                .length(Objects.isNull(source.getLength()) ? river.getLength() : source.getLength())
                .width(Objects.isNull(source.getWidth()) ? river.getWidth() : source.getWidth())
                .nearestProcessingAt(Objects.isNull(source.getNearestProcessingAt()) ? river.getNearestProcessingAt() : source.getNearestProcessingAt())
                .build();
    }
}
