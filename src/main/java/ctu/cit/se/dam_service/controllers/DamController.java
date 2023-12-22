package ctu.cit.se.dam_service.controllers;

import ctu.cit.se.dam_service.applications.specs.IDamApplication;
import ctu.cit.se.dam_service.dtos.requests.dams.CreateDamReqDTO;
import ctu.cit.se.dam_service.dtos.requests.dams.UpdateDamReqDTO;
import ctu.cit.se.dam_service.dtos.responses.commands.CommandResDTO;
import ctu.cit.se.dam_service.dtos.responses.dams.RetrieveDamResDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/dams")
public class DamController {
    @Autowired
    private IDamApplication damApplication;

    @PostMapping
    public ResponseEntity<CommandResDTO> create(@Valid @RequestBody CreateDamReqDTO createDamReqDTO) {
        return new ResponseEntity<>(damApplication.create(createDamReqDTO),HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<CommandResDTO> update(@Valid @RequestBody UpdateDamReqDTO updateDamReqDTO) {
        return new ResponseEntity<>(damApplication.update(updateDamReqDTO), HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<List<RetrieveDamResDTO>> list() {
        return new ResponseEntity<>(damApplication.list(), HttpStatus.OK);
    }

    @GetMapping("/{damId}")
    public ResponseEntity<RetrieveDamResDTO> retrieve(@PathVariable String damId) {
        return new ResponseEntity<>(damApplication.retrieve(UUID.fromString(damId)), HttpStatus.OK);
    }

    @DeleteMapping("/{damId}")
    public ResponseEntity<Void> delete(@PathVariable String damId) {
        damApplication.delete(UUID.fromString(damId));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
