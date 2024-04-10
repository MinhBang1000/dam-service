package ctu.cit.se.dam_service.daos.impls;

import ctu.cit.se.dam_service.daos.mappers.IMapper;
import ctu.cit.se.dam_service.daos.specs.IDamTypeDAO;
import ctu.cit.se.dam_service.daos.specs.IRiverDAO;
import ctu.cit.se.dam_service.dtos.requests.damtypes.CreateDamTypeReqDTO;
import ctu.cit.se.dam_service.dtos.requests.damtypes.UpdateDamTypeReqDTO;
import ctu.cit.se.dam_service.dtos.requests.rivers.CreateRiverReqDTO;
import ctu.cit.se.dam_service.dtos.requests.rivers.UpdateRiverReqDTO;
import ctu.cit.se.dam_service.dtos.responses.commands.CommandResDTO;
import ctu.cit.se.dam_service.dtos.responses.damtypes.RetrieveDamTypeResDTO;
import ctu.cit.se.dam_service.dtos.responses.rivers.RetrieveRiverResDTO;
import ctu.cit.se.dam_service.entites.DamType;
import ctu.cit.se.dam_service.entites.River;
import ctu.cit.se.dam_service.exceptions.messages.CustomExceptionMessage;
import ctu.cit.se.dam_service.repositories.IDamRepository;
import ctu.cit.se.dam_service.repositories.IDamTypeRepository;
import ctu.cit.se.dam_service.repositories.IRiverRepository;
import jakarta.persistence.EntityManager;
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
    private IDamRepository  damRepository;
    @Autowired
    private IMapper<CreateRiverReqDTO, River> createMapper;
    @Autowired
    private IMapper<UpdateRiverReqDTO, River> updateMapper;
    @Autowired
    private IMapper<River, RetrieveRiverResDTO> retrieveMapper;
    @Autowired
    private EntityManager entityManager;

    @Override
    public CommandResDTO create(CreateRiverReqDTO createRiverReqDTO) {
        return CommandResDTO.builder().id(riverRepository.save(createMapper.convert(createRiverReqDTO)).getId().toString()).build();
    }

    @Override
    public CommandResDTO update(UpdateRiverReqDTO updateRiverReqDTO) {
        return CommandResDTO.builder().id(riverRepository.save(updateMapper.convert(updateRiverReqDTO)).getId().toString()).build();
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
        var dams = river.getDams();
        if (!dams.isEmpty()) {
            var defaultRivers = riverRepository.findByCode("init");
            if (!defaultRivers.isEmpty()) {
                var defaultRiver = defaultRivers.get(0);
                dams.stream().forEach(dam -> {
                    dam.setRiver(defaultRiver);
                    damRepository.save(dam);
                });
                damRepository.flush();
                riverRepository.flush();
            }
        }
        // Persistent Context will not be changed if I didn't do that
        entityManager.clear();
        river = riverRepository.findById(riverId).orElseThrow(() -> new IllegalArgumentException(CustomExceptionMessage.RIVER_NOT_FOUND_BY_ID));
        riverRepository.delete(river);
    }

    @Override
    public void initData(List<CreateRiverReqDTO> createRiverReqDTOS) {
        createRiverReqDTOS.stream().forEach(createRiverReqDTO -> {
            var river = createMapper.convert(createRiverReqDTO);
            var rivers = riverRepository.findAll();
            river.setCode("init");
            if (rivers.isEmpty()) {
                riverRepository.save(river);
            }
        });
    }


}
