package ctu.cit.se.dam_service.daos.impls;

import ctu.cit.se.dam_service.daos.mappers.IMapper;
import ctu.cit.se.dam_service.daos.specs.IDamScheduleDAO;
import ctu.cit.se.dam_service.dtos.requests.damschedules.CreateDamScheduleReqDTO;
import ctu.cit.se.dam_service.dtos.requests.damschedules.UpdateDamScheduleReqDTO;
import ctu.cit.se.dam_service.dtos.responses.commands.CommandResDTO;
import ctu.cit.se.dam_service.dtos.responses.damschedules.RetrieveDamScheduleResDTO;
import ctu.cit.se.dam_service.entites.DamSchedule;
import ctu.cit.se.dam_service.exceptions.messages.CustomExceptionMessage;
import ctu.cit.se.dam_service.repositories.IDamScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DamScheduleDAO implements IDamScheduleDAO {
    @Autowired
    private IDamScheduleRepository damScheduleRepository;
    @Autowired
    private IMapper<CreateDamScheduleReqDTO, DamSchedule> createMapper;
    @Autowired
    private IMapper<UpdateDamScheduleReqDTO, DamSchedule> updateMapper;
    @Autowired
    private IMapper<DamSchedule, RetrieveDamScheduleResDTO> retrieveMapper;

    @Override
    public CommandResDTO create(CreateDamScheduleReqDTO createDamScheduleReqDTO) {
        return CommandResDTO.builder().id(damScheduleRepository.save(createMapper.convert(createDamScheduleReqDTO)).getId().toString()).build();
    }

    @Override
    public CommandResDTO update(UpdateDamScheduleReqDTO updateDamScheduleReqDTO) {
        return CommandResDTO.builder().id(damScheduleRepository.save(updateMapper.convert(updateDamScheduleReqDTO)).getId().toString()).build();
    }

    @Override
    public List<RetrieveDamScheduleResDTO> list() {
        return damScheduleRepository.findAll().stream().map(damSchedule -> retrieveMapper.convert(damSchedule)).collect(Collectors.toList());
    }

    @Override
    public RetrieveDamScheduleResDTO retrieve(UUID damScheduleId) {
        var damSchedule = damScheduleRepository.findById(damScheduleId).orElseThrow(() -> new IllegalArgumentException(CustomExceptionMessage.DAM_SCHEDULE_NOT_FOUND_BY_ID));
        return retrieveMapper.convert(damSchedule);
    }

    @Override
    public void delete(UUID damScheduleId) {
        var damSchedule = damScheduleRepository.findById(damScheduleId).orElseThrow(() -> new IllegalArgumentException(CustomExceptionMessage.DAM_SCHEDULE_NOT_FOUND_BY_ID));
        damScheduleRepository.delete(damSchedule);
    }
}
