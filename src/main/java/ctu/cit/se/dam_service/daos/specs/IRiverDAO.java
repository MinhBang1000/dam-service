package ctu.cit.se.dam_service.daos.specs;

import ctu.cit.se.dam_service.dtos.requests.damtypes.CreateDamTypeReqDTO;
import ctu.cit.se.dam_service.dtos.requests.damtypes.UpdateDamTypeReqDTO;
import ctu.cit.se.dam_service.dtos.requests.rivers.CreateRiverReqDTO;
import ctu.cit.se.dam_service.dtos.requests.rivers.UpdateRiverReqDTO;
import ctu.cit.se.dam_service.dtos.responses.commands.CommandResDTO;
import ctu.cit.se.dam_service.dtos.responses.damtypes.RetrieveDamTypeResDTO;
import ctu.cit.se.dam_service.dtos.responses.rivers.RetrieveRiverResDTO;
import ctu.cit.se.dam_service.entites.River;

import java.util.List;
import java.util.UUID;

public interface IRiverDAO {
    CommandResDTO create(CreateRiverReqDTO createRiverReqDTO);
    CommandResDTO update(UpdateRiverReqDTO updateRiverReqDTO);
    List<RetrieveRiverResDTO> list();
    RetrieveRiverResDTO retrieve(UUID riverId);
    void delete(UUID riverId);
    void createInitData(List<River> rivers);
}
