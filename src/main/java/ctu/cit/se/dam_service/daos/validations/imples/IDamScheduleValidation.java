package ctu.cit.se.dam_service.daos.validations.imples;

import ctu.cit.se.dam_service.daos.validations.IValidation;
import ctu.cit.se.dam_service.entites.DamSchedule;
import ctu.cit.se.dam_service.exceptions.messages.CustomExceptionMessage;
import ctu.cit.se.dam_service.repositories.IDamScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class IDamScheduleValidation implements IValidation<DamSchedule> {
    @Autowired
    private IDamScheduleRepository damScheduleRepository;
    @Override
    public Boolean isValid(DamSchedule source) {
        if (Objects.nonNull(source)){
            var damSchedules = damScheduleRepository.findAllByDamIdAndDamStatusId(source.getDam().getId(), source.getDamStatus().getId());
            var checkDamSchedules1 = damSchedules.stream().filter(damSchedule -> damSchedule.getBeginAt().isEqual(source.getBeginAt()) && damSchedule.getEndAt().isEqual(source.getEndAt())).collect(Collectors.toList());
            var checkDamSchedules2 = damSchedules.stream().filter(damSchedule -> {
                return source.getBeginAt().isAfter(damSchedule.getBeginAt()) && source.getBeginAt().isBefore(damSchedule.getEndAt());
            }).collect(Collectors.toList());
            var checkDamSchedules3 = damSchedules.stream().filter(damSchedule -> {
                return source.getEndAt().isAfter(damSchedule.getBeginAt()) && source.getEndAt().isBefore(damSchedule.getEndAt());
            }).collect(Collectors.toList());
            if (!checkDamSchedules1.isEmpty() || !checkDamSchedules2.isEmpty() || !checkDamSchedules3.isEmpty()) {
                return Boolean.FALSE;
            }
        }else {
            throw new IllegalArgumentException(CustomExceptionMessage.DAM_SCHEDULE_IS_NULL);
        }
        return Boolean.TRUE;
    }
}
