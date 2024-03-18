package ctu.cit.se.dam_service.controllers;

import ctu.cit.se.dam_service.applications.specs.IDamScheduleApplication;
import ctu.cit.se.dam_service.dtos.requests.damschedules.CreateDamScheduleReqDTO;
import ctu.cit.se.dam_service.dtos.requests.damschedules.UpdateDamScheduleReqDTO;
import ctu.cit.se.dam_service.dtos.responses.commands.CommandResDTO;
import ctu.cit.se.dam_service.dtos.responses.damschedules.RetrieveDamScheduleBySelectedDateResDTO;
import ctu.cit.se.dam_service.dtos.responses.damschedules.RetrieveDamScheduleResDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/dam-schedules")
public class DamScheduleController {
    @Autowired
    private IDamScheduleApplication damScheduleApplication;

    @PostMapping
    public ResponseEntity<CommandResDTO> create(@Valid @RequestBody CreateDamScheduleReqDTO createDamScheduleReqDTO) {
        return new ResponseEntity<>(damScheduleApplication.create(createDamScheduleReqDTO), HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<CommandResDTO> update(@Valid @RequestBody UpdateDamScheduleReqDTO updateDamScheduleReqDTO) {
        return new ResponseEntity<>(damScheduleApplication.update(updateDamScheduleReqDTO), HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<List<RetrieveDamScheduleResDTO>> list(@RequestParam(name = "damId", required = false) String damId, @RequestParam(name = "damStatusId", required = false) String damStatusId) {
        var damSchedules = damScheduleApplication.list();
        if (Objects.nonNull(damId)) {
            damSchedules = damSchedules.stream().filter(damSchedule -> damSchedule.getDam().getId().equals(damId)).collect(Collectors.toList());
        }
        if (Objects.nonNull(damStatusId)) {
            damSchedules = damSchedules.stream().filter(damSchedule -> damSchedule.getDamStatus().getId().equals(damStatusId)).collect(Collectors.toList());
        }
        return new ResponseEntity<>(damSchedules, HttpStatus.OK);
    }
    @GetMapping("/selected-date/{selectedDate}")
    public ResponseEntity<List<RetrieveDamScheduleBySelectedDateResDTO>> listBySelectedDate(@PathVariable LocalDate selectedDate) {
        return new ResponseEntity<>(damScheduleApplication.listBySelectedDate(selectedDate), HttpStatus.OK);
    }

    @GetMapping("/{damScheduleId}")
    public ResponseEntity<RetrieveDamScheduleResDTO> retrieve(@PathVariable String damScheduleId) {
        return new ResponseEntity<>(damScheduleApplication.retrieve(UUID.fromString(damScheduleId)), HttpStatus.OK);
    }

    @DeleteMapping("/{damScheduleId}")
    public ResponseEntity<Void> delete(@PathVariable String damScheduleId) {
        damScheduleApplication.delete(UUID.fromString(damScheduleId));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
