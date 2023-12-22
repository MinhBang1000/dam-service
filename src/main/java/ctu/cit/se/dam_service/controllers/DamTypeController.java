package ctu.cit.se.dam_service.controllers;

import ctu.cit.se.dam_service.applications.specs.IDamApplication;
import ctu.cit.se.dam_service.applications.specs.IDamTypeApplication;
import ctu.cit.se.dam_service.dtos.requests.dams.CreateDamReqDTO;
import ctu.cit.se.dam_service.dtos.requests.dams.UpdateDamReqDTO;
import ctu.cit.se.dam_service.dtos.requests.damtypes.CreateDamTypeReqDTO;
import ctu.cit.se.dam_service.dtos.requests.damtypes.UpdateDamTypeReqDTO;
import ctu.cit.se.dam_service.dtos.responses.commands.CommandResDTO;
import ctu.cit.se.dam_service.dtos.responses.dams.RetrieveDamResDTO;
import ctu.cit.se.dam_service.dtos.responses.damtypes.RetrieveDamTypeResDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/dam-types")
public class DamTypeController {
    @Autowired
    private IDamTypeApplication damTypeApplication;

    @PostMapping
    public ResponseEntity<CommandResDTO> create(@Valid @RequestBody CreateDamTypeReqDTO createDamTypeReqDTO) {
        return new ResponseEntity<>(damTypeApplication.create(createDamTypeReqDTO), HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<CommandResDTO> update(@Valid @RequestBody UpdateDamTypeReqDTO updateDamTypeReqDTO) {
        return new ResponseEntity<>(damTypeApplication.update(updateDamTypeReqDTO), HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<List<RetrieveDamTypeResDTO>> list() {
        return new ResponseEntity<>(damTypeApplication.list(), HttpStatus.OK);
    }

    @GetMapping("/{damTypeId}")
    public ResponseEntity<RetrieveDamTypeResDTO> retrieve(@PathVariable String damTypeId) {
        return new ResponseEntity<>(damTypeApplication.retrieve(UUID.fromString(damTypeId)), HttpStatus.OK);
    }

    @DeleteMapping("/{damTypeId}")
    public ResponseEntity<Void> delete(@PathVariable String damTypeId) {
        damTypeApplication.delete(UUID.fromString(damTypeId));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
