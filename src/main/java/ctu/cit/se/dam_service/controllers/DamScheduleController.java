package ctu.cit.se.dam_service.controllers;

import ctu.cit.se.dam_service.applications.specs.IDamScheduleApplication;
import ctu.cit.se.dam_service.applications.specs.IDamStatusApplication;
import ctu.cit.se.dam_service.dtos.requests.damschedules.CreateDamScheduleReqDTO;
import ctu.cit.se.dam_service.dtos.requests.damschedules.UpdateDamScheduleReqDTO;
import ctu.cit.se.dam_service.dtos.requests.damstatuses.CreateDamStatusReqDTO;
import ctu.cit.se.dam_service.dtos.requests.damstatuses.UpdateDamStatusReqDTO;
import ctu.cit.se.dam_service.dtos.responses.commands.CommandResDTO;
import ctu.cit.se.dam_service.dtos.responses.damschedules.RetrieveDamScheduleResDTO;
import ctu.cit.se.dam_service.dtos.responses.damstatuses.RetrieveDamStatusResDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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
    public ResponseEntity<List<RetrieveDamScheduleResDTO>> list() {
        return new ResponseEntity<>(damScheduleApplication.list(), HttpStatus.OK);
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
