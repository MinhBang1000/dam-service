package ctu.cit.se.dam_service.daos.impls;

import ctu.cit.se.dam_service.daos.mappers.IMapper;
import ctu.cit.se.dam_service.daos.specs.IDamScheduleDAO;
import ctu.cit.se.dam_service.daos.validations.IValidation;
import ctu.cit.se.dam_service.dtos.requests.damschedules.CreateDamScheduleReqDTO;
import ctu.cit.se.dam_service.dtos.requests.damschedules.UpdateDamScheduleReqDTO;
import ctu.cit.se.dam_service.dtos.responses.commands.CommandResDTO;
import ctu.cit.se.dam_service.dtos.responses.damschedules.RetrieveDamScheduleBySelectedDateResDTO;
import ctu.cit.se.dam_service.dtos.responses.damschedules.RetrieveDamScheduleResDTO;
import ctu.cit.se.dam_service.dtos.responses.damschedules.RetrieveDamScheduleShorterVersionResDTO;
import ctu.cit.se.dam_service.entites.Dam;
import ctu.cit.se.dam_service.entites.DamSchedule;
import ctu.cit.se.dam_service.entites.DamStatus;
import ctu.cit.se.dam_service.exceptions.messages.CustomExceptionMessage;
import ctu.cit.se.dam_service.repositories.IDamRepository;
import ctu.cit.se.dam_service.repositories.IDamScheduleRepository;
import ctu.cit.se.dam_service.repositories.IDamStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DamScheduleDAO implements IDamScheduleDAO {
    @Autowired
    private IDamScheduleRepository damScheduleRepository;
    @Autowired
    private IDamRepository damRepository;
    @Autowired
    private IDamStatusRepository damStatusRepository;
    @Autowired
    private IMapper<CreateDamScheduleReqDTO, DamSchedule> createMapper;
    @Autowired
    private IMapper<UpdateDamScheduleReqDTO, DamSchedule> updateMapper;
    @Autowired
    private IMapper<DamSchedule, RetrieveDamScheduleResDTO> retrieveMapper;
    @Autowired
    private IMapper<Dam, RetrieveDamScheduleBySelectedDateResDTO> retrieveBySelectedDateMapper;
    @Autowired
    private IMapper<DamSchedule, RetrieveDamScheduleShorterVersionResDTO> retrieveDamScheduleShorterVersionMapper;

    @Autowired
    private IValidation<DamSchedule> damScheduleValidation;

    @Override
    public CommandResDTO create(CreateDamScheduleReqDTO createDamScheduleReqDTO) {
        var creatingDamSchedule = createMapper.convert(createDamScheduleReqDTO);
        var checker = damScheduleValidation.isValid(creatingDamSchedule);
        if (!checker.getStatus()) {
            throw new IllegalArgumentException(checker.getMessage());
        }
        return CommandResDTO.builder().id(damScheduleRepository.save(creatingDamSchedule).getId().toString()).build();
    }

    @Override
    public CommandResDTO update(UpdateDamScheduleReqDTO updateDamScheduleReqDTO) {
        var updatingDamSchedule = updateMapper.convert(updateDamScheduleReqDTO);
        var checker = damScheduleValidation.isValid(updatingDamSchedule);
        if (!checker.getStatus()) {
            throw new IllegalArgumentException(checker.getMessage());
        }
        return CommandResDTO.builder().id(damScheduleRepository.save(updatingDamSchedule).getId().toString()).build();
    }

    @Override
    public List<RetrieveDamScheduleResDTO> list() {
        return damScheduleRepository.findAllByOrderByBeginAtAsc().stream().map(damSchedule -> retrieveMapper.convert(damSchedule)).collect(Collectors.toList());
    }

    @Override
    public List<RetrieveDamScheduleBySelectedDateResDTO> listBySelectedDate(LocalDate selectedDate) {
        if (Objects.isNull(selectedDate)) {
            throw new IllegalArgumentException(CustomExceptionMessage.DAM_SCHEDULE_SELECTED_DATE_INVALID);
        }
        var dams = damRepository.findAll();
        var filteredDamSchedulesSelectedByDate = dams.stream().map((dam) -> {
            var damSchedules = dam.getDamSchedules();
            List<RetrieveDamScheduleShorterVersionResDTO> retrieveDamScheduleShorterVersionResDTOS = new ArrayList<>();
            if (Objects.nonNull(damSchedules)) {
                retrieveDamScheduleShorterVersionResDTOS = damSchedules.stream().filter(damSchedule -> {
                    if (damSchedule.getIsLock()) {
                        return false;
                    }
                    if (damSchedule.getBeginAt().toLocalDate().isEqual(selectedDate)){
                        return true;
                    }
                    if (damSchedule.getEndAt().toLocalDate().isEqual(selectedDate)) {
                        return true;
                    }
                    return damSchedule.getBeginAt().toLocalDate().isBefore(selectedDate) && damSchedule.getEndAt().toLocalDate().isAfter(selectedDate);
                }).map(damSchedule -> {
                    return retrieveDamScheduleShorterVersionMapper.convert(damSchedule);
                }).collect(Collectors.toList());
            }
            RetrieveDamScheduleBySelectedDateResDTO retrieveDamScheduleBySelectedDateResDTO = retrieveBySelectedDateMapper.convert(dam);
            retrieveDamScheduleBySelectedDateResDTO.setDamSchedules(retrieveDamScheduleShorterVersionResDTOS);
            Boolean currentStatus = false;
            DamStatus damStatus = DamStatus.builder().name("CLOSE").build();
            if (!retrieveDamScheduleShorterVersionResDTOS.isEmpty()) {
                currentStatus = true;
            }
            if (currentStatus) {
                try {
                    var damOpenStatus = damStatusRepository.findByName("OPEN").get();
                    damStatus = damOpenStatus;
                }catch (Exception ex) {
                    damStatus.setName("OPEN");
                    var damOpenStatus = damStatusRepository.save(damStatus);
                    damStatus = damOpenStatus;
                }
            }else {
                try {
                    var damCloseStatus = damStatusRepository.findByName("CLOSE").get();
                    damStatus = damCloseStatus;
                }catch (Exception ex) {
                    var damCloseStatus = damStatusRepository.save(damStatus);
                    damStatus = damCloseStatus;
                }
            }
            retrieveDamScheduleBySelectedDateResDTO.setStatusName(damStatus.getName());
            return retrieveDamScheduleBySelectedDateResDTO;
        }).collect(Collectors.toList());
        return filteredDamSchedulesSelectedByDate;
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
