package ctu.cit.se.dam_service.daos.impls;

import ctu.cit.se.dam_service.daos.mappers.IMapper;
import ctu.cit.se.dam_service.daos.specs.IDamTypeDAO;
import ctu.cit.se.dam_service.daos.specs.IRiverDAO;
import ctu.cit.se.dam_service.dtos.requests.damtypes.CreateDamTypeReqDTO;
import ctu.cit.se.dam_service.dtos.requests.damtypes.UpdateDamTypeReqDTO;
import ctu.cit.se.dam_service.dtos.requests.rivers.CreateRiverReqDTO;
import ctu.cit.se.dam_service.dtos.requests.rivers.UpdateRiverReqDTO;
import ctu.cit.se.dam_service.dtos.responses.damtypes.RetrieveDamTypeResDTO;
import ctu.cit.se.dam_service.dtos.responses.rivers.RetrieveRiverResDTO;
import ctu.cit.se.dam_service.entites.DamType;
import ctu.cit.se.dam_service.entites.River;
import ctu.cit.se.dam_service.exceptions.messages.CustomExceptionMessage;
import ctu.cit.se.dam_service.repositories.IDamTypeRepository;
import ctu.cit.se.dam_service.repositories.IRiverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RiverDAO implements IRiverDAO {
    @Autowired
    private IRiverRepository riverRepository;
    @Autowired
    private IMapper<CreateRiverReqDTO, River> createMapper;
    @Autowired
    private IMapper<UpdateRiverReqDTO, River> updateMapper;
    @Autowired
    private IMapper<River, RetrieveRiverResDTO> retrieveMapper;

    @Override
    public void create(CreateRiverReqDTO createRiverReqDTO) {
        riverRepository.save(createMapper.convert(createRiverReqDTO));
    }

    @Override
    public void update(UpdateRiverReqDTO updateRiverReqDTO) {
        riverRepository.save(updateMapper.convert(updateRiverReqDTO));
    }

    @Override
    public List<RetrieveRiverResDTO> list() {
        return riverRepository.findAll().stream().map(river -> retrieveMapper.convert(river)).collect(Collectors.toList());
    }

    @Override
    public RetrieveRiverResDTO retrieve(UUID riverId) {
        var river = riverRepository.findById(riverId).orElseThrow(() -> new IllegalArgumentException(CustomExceptionMessage.RIVER_NOT_FOUND_BY_ID));
        return retrieveMapper.convert(river);
    }

    @Override
    public void delete(UUID riverId) {
        var river = riverRepository.findById(riverId).orElseThrow(() -> new IllegalArgumentException(CustomExceptionMessage.RIVER_NOT_FOUND_BY_ID));
        riverRepository.delete(river);
    }
}
