package ctu.cit.se.dam_service.daos.impls;

import ctu.cit.se.dam_service.daos.mappers.IMapper;
import ctu.cit.se.dam_service.daos.specs.IDamLocationDAO;
import ctu.cit.se.dam_service.dtos.requests.damlocations.CreateDamLocationReqDTO;
import ctu.cit.se.dam_service.dtos.requests.damlocations.UpdateDamLocationReqDTO;
import ctu.cit.se.dam_service.dtos.requests.damschedules.CreateDamScheduleReqDTO;
import ctu.cit.se.dam_service.dtos.requests.damschedules.UpdateDamScheduleReqDTO;
import ctu.cit.se.dam_service.dtos.responses.commands.CommandResDTO;
import ctu.cit.se.dam_service.dtos.responses.damlocations.RetrieveDamLocationResDTO;
import ctu.cit.se.dam_service.dtos.responses.damschedules.RetrieveDamScheduleResDTO;
import ctu.cit.se.dam_service.entites.DamLocation;
import ctu.cit.se.dam_service.entites.DamSchedule;
import ctu.cit.se.dam_service.exceptions.messages.CustomExceptionMessage;
import ctu.cit.se.dam_service.repositories.IDamLocationRepository;
import ctu.cit.se.dam_service.repositories.IDamScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DamLocationDAO implements IDamLocationDAO {
    @Autowired
    private IDamLocationRepository damLocationRepository;
    @Autowired
    private IMapper<CreateDamLocationReqDTO, DamLocation> createMapper;
    @Autowired
    private IMapper<UpdateDamLocationReqDTO, DamLocation> updateMapper;
    @Autowired
    private IMapper<DamLocation, RetrieveDamLocationResDTO> retrieveMapper;

    @Override
    public CommandResDTO create(CreateDamLocationReqDTO createDamLocationReqDTO) {
        return CommandResDTO.builder().id(damLocationRepository.save(createMapper.convert(createDamLocationReqDTO)).getId().toString()).build();
    }

    @Override
    public CommandResDTO update(UpdateDamLocationReqDTO updateDamLocationReqDTO) {
        return CommandResDTO.builder().id(damLocationRepository.save(updateMapper.convert(updateDamLocationReqDTO)).getId().toString()).build();
    }

    @Override
    public List<RetrieveDamLocationResDTO> list() {
        return damLocationRepository.findAll().stream().map(damLocation -> retrieveMapper.convert(damLocation)).collect(Collectors.toList());
    }

    @Override
    public RetrieveDamLocationResDTO retrieve(UUID damLocationId) {
        var damLocation = damLocationRepository.findById(damLocationId).orElseThrow(() -> new IllegalArgumentException(CustomExceptionMessage.DAM_LOCATION_NOT_FOUND_BY_ID));
        return retrieveMapper.convert(damLocation);
    }

    @Override
    public void delete(UUID damLocationId) {
        var damLocation = damLocationRepository.findById(damLocationId).orElseThrow(() -> new IllegalArgumentException(CustomExceptionMessage.DAM_LOCATION_NOT_FOUND_BY_ID));
        damLocationRepository.delete(damLocation);
    }
}
