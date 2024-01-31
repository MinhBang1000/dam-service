package ctu.cit.se.dam_service.controllers;

import ctu.cit.se.dam_service.applications.specs.IDamLocationApplication;
import ctu.cit.se.dam_service.applications.specs.IRiverLocationApplication;
import ctu.cit.se.dam_service.dtos.requests.damlocations.CreateDamLocationReqDTO;
import ctu.cit.se.dam_service.dtos.requests.damlocations.UpdateDamLocationReqDTO;
import ctu.cit.se.dam_service.dtos.requests.riverlocations.CreateRiverLocationReqDTO;
import ctu.cit.se.dam_service.dtos.requests.riverlocations.UpdateRiverLocationReqDTO;
import ctu.cit.se.dam_service.dtos.responses.commands.CommandResDTO;
import ctu.cit.se.dam_service.dtos.responses.damlocations.RetrieveDamLocationResDTO;
import ctu.cit.se.dam_service.dtos.responses.riverlocations.RetrieveRiverLocationResDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/river-locations")
public class RiverLocationController {
    @Autowired
    private IRiverLocationApplication riverLocationApplication;

    @PostMapping
    public ResponseEntity<CommandResDTO> create(@Valid @RequestBody CreateRiverLocationReqDTO createRiverLocationReqDTO) {
        return new ResponseEntity<>(riverLocationApplication.create(createRiverLocationReqDTO), HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<CommandResDTO> update(@Valid @RequestBody UpdateRiverLocationReqDTO updateRiverLocationReqDTO) {
        return new ResponseEntity<>(riverLocationApplication.update(updateRiverLocationReqDTO), HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<List<RetrieveRiverLocationResDTO>> list() {
        return new ResponseEntity<>(riverLocationApplication.list(), HttpStatus.OK);
    }

    @GetMapping("/{riverLocationId}")
    public ResponseEntity<RetrieveRiverLocationResDTO> retrieve(@PathVariable String riverLocationId) {
        return new ResponseEntity<>(riverLocationApplication.retrieve(UUID.fromString(riverLocationId)), HttpStatus.OK);
    }

    @DeleteMapping("/{riverLocationId}")
    public ResponseEntity<Void> delete(@PathVariable String riverLocationId) {
        riverLocationApplication.delete(UUID.fromString(riverLocationId));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
