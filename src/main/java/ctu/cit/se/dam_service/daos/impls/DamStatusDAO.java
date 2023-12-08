package ctu.cit.se.dam_service.daos.impls;

import ctu.cit.se.dam_service.daos.mappers.IMapper;
import ctu.cit.se.dam_service.daos.specs.IDamStatusDAO;
import ctu.cit.se.dam_service.dtos.requests.damstatuses.CreateDamStatusReqDTO;
import ctu.cit.se.dam_service.dtos.requests.damstatuses.UpdateDamStatusReqDTO;
import ctu.cit.se.dam_service.dtos.responses.commands.CommandResDTO;
import ctu.cit.se.dam_service.dtos.responses.damstatuses.RetrieveDamStatusResDTO;
import ctu.cit.se.dam_service.dtos.responses.damtypes.RetrieveDamTypeResDTO;
import ctu.cit.se.dam_service.entites.DamStatus;
import ctu.cit.se.dam_service.exceptions.messages.CustomExceptionMessage;
import ctu.cit.se.dam_service.repositories.IDamStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DamStatusDAO implements IDamStatusDAO {
    @Autowired
    private IDamStatusRepository damStatusRepository;
    @Autowired
    private IMapper<CreateDamStatusReqDTO, DamStatus> createMapper;
    @Autowired
    private IMapper<UpdateDamStatusReqDTO, DamStatus> updateMapper;
    @Autowired
    private IMapper<DamStatus, RetrieveDamStatusResDTO> retrieveMapper;

    @Override
    public CommandResDTO create(CreateDamStatusReqDTO createDamStatusReqDTO) {
        return CommandResDTO.builder().id(damStatusRepository.save(createMapper.convert(createDamStatusReqDTO)).getId().toString()).build();
    }

    @Override
    public CommandResDTO update(UpdateDamStatusReqDTO updateDamStatusReqDTO) {
        return CommandResDTO.builder().id(damStatusRepository.save(updateMapper.convert(updateDamStatusReqDTO)).getId().toString()).build();
    }

    @Override
    public List<RetrieveDamStatusResDTO> list() {
        return damStatusRepository.findAll().stream().map(damStatus -> retrieveMapper.convert(damStatus)).collect(Collectors.toList());
    }

    @Override
    public RetrieveDamStatusResDTO retrieve(UUID damStatusId) {
        var damStatus = damStatusRepository.findById(damStatusId).orElseThrow(() -> new IllegalArgumentException(CustomExceptionMessage.DAM_STATUS_NOT_FOUND_BY_ID));
        return retrieveMapper.convert(damStatus);
    }

    @Override
    public void delete(UUID damStatusId) {
        var damStatus = damStatusRepository.findById(damStatusId).orElseThrow(() -> new IllegalArgumentException(CustomExceptionMessage.DAM_STATUS_NOT_FOUND_BY_ID));
        damStatusRepository.delete(damStatus);
    }
}
