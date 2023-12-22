package ctu.cit.se.dam_service.controllers;

import ctu.cit.se.dam_service.applications.specs.IDamApplication;
import ctu.cit.se.dam_service.applications.specs.IRiverApplication;
import ctu.cit.se.dam_service.dtos.requests.dams.CreateDamReqDTO;
import ctu.cit.se.dam_service.dtos.requests.dams.UpdateDamReqDTO;
import ctu.cit.se.dam_service.dtos.requests.rivers.CreateRiverReqDTO;
import ctu.cit.se.dam_service.dtos.requests.rivers.UpdateRiverReqDTO;
import ctu.cit.se.dam_service.dtos.responses.commands.CommandResDTO;
import ctu.cit.se.dam_service.dtos.responses.dams.RetrieveDamResDTO;
import ctu.cit.se.dam_service.dtos.responses.rivers.RetrieveRiverResDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/rivers")
public class RiverController {
    @Autowired
    private IRiverApplication riverApplication;

    @PostMapping
    public ResponseEntity<CommandResDTO> create(@Valid @RequestBody CreateRiverReqDTO createRiverReqDTO) {
        return new ResponseEntity<>(riverApplication.create(createRiverReqDTO), HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<CommandResDTO> update(@Valid @RequestBody UpdateRiverReqDTO updateRiverReqDTO) {
        return new ResponseEntity<>(riverApplication.update(updateRiverReqDTO), HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<List<RetrieveRiverResDTO>> list() {
        return new ResponseEntity<>(riverApplication.list(), HttpStatus.OK);
    }

    @GetMapping("/{riverId}")
    public ResponseEntity<RetrieveRiverResDTO> retrieve(@PathVariable String riverId) {
        return new ResponseEntity<>(riverApplication.retrieve(UUID.fromString(riverId)), HttpStatus.OK);
    }

    @DeleteMapping("/{riverId}")
    public ResponseEntity<Void> delete(@PathVariable String riverId) {
        riverApplication.delete(UUID.fromString(riverId));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
