package ctu.cit.se.dam_service.repositories;

import ctu.cit.se.dam_service.entites.Dam;
import ctu.cit.se.dam_service.entites.DamType;
import ctu.cit.se.dam_service.entites.River;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IDamRepository extends JpaRepository<Dam, UUID> {
    List<Dam> queryByDamType(DamType damType);
    List<Dam> queryByRiver(River river);
}
