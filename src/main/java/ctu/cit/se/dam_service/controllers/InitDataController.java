package ctu.cit.se.dam_service.controllers;

import ctu.cit.se.dam_service.daos.specs.IDamTypeDAO;
import ctu.cit.se.dam_service.daos.specs.IRiverDAO;
import ctu.cit.se.dam_service.dtos.requests.damtypes.CreateDamTypeReqDTO;
import ctu.cit.se.dam_service.dtos.requests.rivers.CreateRiverReqDTO;
import ctu.cit.se.dam_service.migrations.IBaseInitData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/init-data")
public class InitDataController {
    @Autowired
    private IBaseInitData<CreateDamTypeReqDTO> damTypeInitData;
    @Autowired
    private IBaseInitData<CreateRiverReqDTO> riverInitData;
    @Autowired
    private IDamTypeDAO damTypeDAO;
    @Autowired
    private IRiverDAO riverDAO;

    @PostMapping
    public ResponseEntity<Void> createInitData() {
        damTypeDAO.initData(damTypeInitData.getInitData());
        riverDAO.initData(riverInitData.getInitData());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
