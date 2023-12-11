package ctu.cit.se.dam_service.controllers;

import ctu.cit.se.dam_service.applications.specs.IDamApplication;
import ctu.cit.se.dam_service.applications.specs.IDamStatusApplication;
import ctu.cit.se.dam_service.dtos.requests.dams.CreateDamReqDTO;
import ctu.cit.se.dam_service.dtos.requests.dams.UpdateDamReqDTO;
import ctu.cit.se.dam_service.dtos.requests.damstatuses.CreateDamStatusReqDTO;
import ctu.cit.se.dam_service.dtos.requests.damstatuses.UpdateDamStatusReqDTO;
import ctu.cit.se.dam_service.dtos.responses.commands.CommandResDTO;
import ctu.cit.se.dam_service.dtos.responses.dams.RetrieveDamResDTO;
import ctu.cit.se.dam_service.dtos.responses.damstatuses.RetrieveDamStatusResDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/dam-statuses")
public class DamStatusController {
    @Autowired
    private IDamStatusApplication damStatusApplication;

    @PostMapping
    public ResponseEntity<CommandResDTO> create(@Valid @RequestBody CreateDamStatusReqDTO createDamStatusReqDTO) {
        return new ResponseEntity<>(damStatusApplication.create(createDamStatusReqDTO), HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<CommandResDTO> update(@RequestBody UpdateDamStatusReqDTO updateDamStatusReqDTO) {
        return new ResponseEntity<>(damStatusApplication.update(updateDamStatusReqDTO), HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<List<RetrieveDamStatusResDTO>> list() {
        return new ResponseEntity<>(damStatusApplication.list(), HttpStatus.OK);
    }

    @GetMapping("/{damStatusId}")
    public ResponseEntity<RetrieveDamStatusResDTO> retrieve(@PathVariable String damStatusId) {
        return new ResponseEntity<>(damStatusApplication.retrieve(UUID.fromString(damStatusId)), HttpStatus.OK);
    }

    @DeleteMapping("/{damStatusId}")
    public ResponseEntity<Void> delete(@PathVariable String damStatusId) {
        damStatusApplication.delete(UUID.fromString(damStatusId));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
