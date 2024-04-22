package ctu.cit.se.dam_service.controllers;

import ctu.cit.se.dam_service.daos.specs.IDamTypeDAO;
import ctu.cit.se.dam_service.daos.specs.IRiverDAO;
import ctu.cit.se.dam_service.entites.DamType;
import ctu.cit.se.dam_service.entites.River;
import ctu.cit.se.dam_service.migrations.IBaseInitData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/init-data")
public class InitDataController {
    @Autowired
    private IRiverDAO riverDAO;
    @Autowired
    private IDamTypeDAO damTypeDAO;
    @Autowired
    private IBaseInitData<River> riverIBaseInitData;
    @Autowired
    private IBaseInitData<DamType> damTypeIBaseInitData;
    @PostMapping
    public ResponseEntity<String> createInitData() {
        riverDAO.createInitData(riverIBaseInitData.getInitData());
        damTypeDAO.createInitData(damTypeIBaseInitData.getInitData());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
