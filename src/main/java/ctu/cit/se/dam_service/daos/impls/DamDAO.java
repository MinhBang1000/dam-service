package ctu.cit.se.dam_service.daos.impls;

import ctu.cit.se.dam_service.daos.mappers.IMapper;
import ctu.cit.se.dam_service.daos.specs.IDamDAO;
import ctu.cit.se.dam_service.dtos.requests.dams.CreateDamReqDTO;
import ctu.cit.se.dam_service.dtos.requests.dams.UpdateDamReqDTO;
import ctu.cit.se.dam_service.dtos.responses.dams.RetrieveDamResDTO;
import ctu.cit.se.dam_service.entites.Dam;
import ctu.cit.se.dam_service.exceptions.messages.CustomExceptionMessage;
import ctu.cit.se.dam_service.repositories.IDamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
@Service
public class DamDAO implements IDamDAO {
    @Autowired
    private IDamRepository damRepository;
    @Autowired
    private IMapper<CreateDamReqDTO, Dam> createMapper;
    @Autowired
    private IMapper<UpdateDamReqDTO, Dam> updateMapper;
    @Autowired
    private IMapper<Dam, RetrieveDamResDTO> retrieveMapper;

    @Override
    public void create(CreateDamReqDTO createDamReqDTO) {
        damRepository.save(createMapper.convert(createDamReqDTO));
    }

    @Override
    public void update(UpdateDamReqDTO updateDamReqDTO) {
        damRepository.save(updateMapper.convert(updateDamReqDTO));
    }

    @Override
    public List<RetrieveDamResDTO> list() {
        return damRepository.findAll().stream().map(dam -> retrieveMapper.convert(dam)).collect(Collectors.toList());
    }

    @Override
    public RetrieveDamResDTO retrieve(UUID damId) {
        var dam = damRepository.findById(damId).orElseThrow(() -> new IllegalArgumentException(CustomExceptionMessage.DAM_NOT_FOUND_BY_ID));
        return retrieveMapper.convert(dam);
    }

    @Override
    public void delete(UUID damId) {
        var dam = damRepository.findById(damId).orElseThrow(() -> new IllegalArgumentException(CustomExceptionMessage.DAM_NOT_FOUND_BY_ID));
        damRepository.delete(dam);
    }
}
