package ctu.cit.se.dam_service.repositories;

import ctu.cit.se.dam_service.entites.Dam;
import ctu.cit.se.dam_service.entites.DamType;
import ctu.cit.se.dam_service.entites.River;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface IDamRepository extends JpaRepository<Dam, UUID> {
    List<Dam> queryByDamType(DamType damType);
    List<Dam> queryByRiver(River river);
}
