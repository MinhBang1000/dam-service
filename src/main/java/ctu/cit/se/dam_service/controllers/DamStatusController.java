package ctu.cit.se.dam_service.controllers;

import ctu.cit.se.dam_service.applications.specs.IDamApplication;
import ctu.cit.se.dam_service.applications.specs.IDamStatusApplication;
import ctu.cit.se.dam_service.dtos.requests.dams.CreateDamReqDTO;
import ctu.cit.se.dam_service.dtos.requests.dams.UpdateDamReqDTO;
import ctu.cit.se.dam_service.dtos.requests.damstatuses.CreateDamStatusReqDTO;
import ctu.cit.se.dam_service.dtos.requests.damstatuses.UpdateDamStatusReqDTO;
import ctu.cit.se.dam_service.dtos.responses.dams.RetrieveDamResDTO;
import ctu.cit.se.dam_service.dtos.responses.damstatuses.RetrieveDamStatusResDTO;
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
    public ResponseEntity<Void> create(@RequestBody CreateDamStatusReqDTO createDamStatusReqDTO) {
        damStatusApplication.create(createDamStatusReqDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<Void> update(@RequestBody UpdateDamStatusReqDTO updateDamStatusReqDTO) {
        damStatusApplication.update(updateDamStatusReqDTO);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<List<RetrieveDamStatusResDTO>> list() {
        return new ResponseEntity<>(damStatusApplication.list(), HttpStatus.OK);
    }

    @GetMapping("/{damId}")
    public ResponseEntity<RetrieveDamStatusResDTO> retrieve(@PathVariable String damId) {
        return new ResponseEntity<>(damStatusApplication.retrieve(Long.parseLong(damId)), HttpStatus.OK);
    }

    @DeleteMapping("/{damId}")
    public ResponseEntity<Void> delete(@PathVariable String damId) {
        damStatusApplication.delete(Long.parseLong(damId));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
