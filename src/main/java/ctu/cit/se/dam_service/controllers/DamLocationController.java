package ctu.cit.se.dam_service.controllers;

import ctu.cit.se.dam_service.applications.specs.IDamLocationApplication;
import ctu.cit.se.dam_service.dtos.requests.damlocations.CreateDamLocationReqDTO;
import ctu.cit.se.dam_service.dtos.requests.damlocations.UpdateDamLocationReqDTO;
import ctu.cit.se.dam_service.dtos.requests.damtypes.CreateDamTypeReqDTO;
import ctu.cit.se.dam_service.dtos.requests.damtypes.UpdateDamTypeReqDTO;
import ctu.cit.se.dam_service.dtos.responses.commands.CommandResDTO;
import ctu.cit.se.dam_service.dtos.responses.damlocations.RetrieveDamLocationResDTO;
import ctu.cit.se.dam_service.dtos.responses.damtypes.RetrieveDamTypeResDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/dam-locations")
public class DamLocationController {
    @Autowired
    private IDamLocationApplication damLocationApplication;

    @PostMapping
    public ResponseEntity<CommandResDTO> create(@Valid @RequestBody CreateDamLocationReqDTO createDamLocationReqDTO) {
        return new ResponseEntity<>(damLocationApplication.create(createDamLocationReqDTO), HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<CommandResDTO> update(@Valid @RequestBody UpdateDamLocationReqDTO updateDamLocationReqDTO) {
        return new ResponseEntity<>(damLocationApplication.update(updateDamLocationReqDTO), HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<List<RetrieveDamLocationResDTO>> list() {
        return new ResponseEntity<>(damLocationApplication.list(), HttpStatus.OK);
    }

    @GetMapping("/{damLocationId}")
    public ResponseEntity<RetrieveDamLocationResDTO> retrieve(@PathVariable String damLocationId) {
        return new ResponseEntity<>(damLocationApplication.retrieve(UUID.fromString(damLocationId)), HttpStatus.OK);
    }

    @DeleteMapping("/{damLocationId}")
    public ResponseEntity<Void> delete(@PathVariable String damLocationId) {
        damLocationApplication.delete(UUID.fromString(damLocationId));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
