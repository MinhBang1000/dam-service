package ctu.cit.se.dam_service.daos.impls;

import ctu.cit.se.dam_service.daos.mappers.IMapper;
import ctu.cit.se.dam_service.daos.specs.IRiverLocationDAO;
import ctu.cit.se.dam_service.dtos.requests.damlocations.CreateDamLocationReqDTO;
import ctu.cit.se.dam_service.dtos.requests.damlocations.UpdateDamLocationReqDTO;
import ctu.cit.se.dam_service.dtos.requests.riverlocations.CreateRiverLocationReqDTO;
import ctu.cit.se.dam_service.dtos.requests.riverlocations.UpdateRiverLocationReqDTO;
import ctu.cit.se.dam_service.dtos.responses.commands.CommandResDTO;
import ctu.cit.se.dam_service.dtos.responses.damlocations.RetrieveDamLocationResDTO;
import ctu.cit.se.dam_service.dtos.responses.riverlocations.RetrieveRiverLocationResDTO;
import ctu.cit.se.dam_service.entites.DamLocation;
import ctu.cit.se.dam_service.entites.RiverLocation;
import ctu.cit.se.dam_service.exceptions.messages.CustomExceptionMessage;
import ctu.cit.se.dam_service.repositories.IDamLocationRepository;
import ctu.cit.se.dam_service.repositories.IRiverLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RiverLocationDAO implements IRiverLocationDAO {
    @Autowired
    private IRiverLocationRepository riverLocationRepository;
    @Autowired
    private IMapper<CreateRiverLocationReqDTO, RiverLocation> createMapper;
    @Autowired
    private IMapper<UpdateRiverLocationReqDTO, RiverLocation> updateMapper;
    @Autowired
    private IMapper<RiverLocation, RetrieveRiverLocationResDTO> retrieveMapper;

    @Override
    public CommandResDTO create(CreateRiverLocationReqDTO createRiverLocationReqDTO) {
        return CommandResDTO.builder().id(riverLocationRepository.save(createMapper.convert(createRiverLocationReqDTO)).getId().toString()).build();
    }

    @Override
    public CommandResDTO update(UpdateRiverLocationReqDTO updateRiverLocationReqDTO) {
        return CommandResDTO.builder().id(riverLocationRepository.save(updateMapper.convert(updateRiverLocationReqDTO)).getId().toString()).build();
    }

    @Override
    public List<RetrieveRiverLocationResDTO> list() {
        return riverLocationRepository.findAll().stream().map(riverLocation -> retrieveMapper.convert(riverLocation)).collect(Collectors.toList());
    }

    @Override
    public RetrieveRiverLocationResDTO retrieve(UUID riverLocationId) {
        var riverLocation = riverLocationRepository.findById(riverLocationId).orElseThrow(() -> new IllegalArgumentException(CustomExceptionMessage.RIVER_LOCATION_NOT_FOUND_BY_ID));
        return retrieveMapper.convert(riverLocation);
    }

    @Override
    public void delete(UUID riverLocationId) {
        var riverLocation = riverLocationRepository.findById(riverLocationId).orElseThrow(() -> new IllegalArgumentException(CustomExceptionMessage.RIVER_LOCATION_NOT_FOUND_BY_ID));
        riverLocationRepository.delete(riverLocation);
    }
}
