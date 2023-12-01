package ctu.cit.se.dam_service.controllers;

import ctu.cit.se.dam_service.applications.specs.IDamApplication;
import ctu.cit.se.dam_service.dtos.requests.dams.CreateDamReqDTO;
import ctu.cit.se.dam_service.dtos.requests.dams.UpdateDamReqDTO;
import ctu.cit.se.dam_service.dtos.responses.dams.RetrieveDamResDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/dams")
public class DamController {
    @Autowired
    private IDamApplication damApplication;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateDamReqDTO createDamReqDTO) {
        damApplication.create(createDamReqDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<Void> update(@RequestBody UpdateDamReqDTO updateDamReqDTO) {
        damApplication.update(updateDamReqDTO);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<List<RetrieveDamResDTO>> list(@RequestParam(name = "isLock", required = false) Boolean isLock) {
        return new ResponseEntity<>(Objects.nonNull(isLock) ? damApplication.list().stream().filter(retrieveDamResDTO -> retrieveDamResDTO.getIsLock() == isLock).collect(Collectors.toList()) : damApplication.list(), HttpStatus.OK);
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
