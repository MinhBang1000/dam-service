package ctu.cit.se.dam_service.repositories;

import ctu.cit.se.dam_service.entites.DamType;
import ctu.cit.se.dam_service.entites.River;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface IRiverRepository extends JpaRepository<River, UUID> {
    Optional<River> findByCode(String code);
}
