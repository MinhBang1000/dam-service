package ctu.cit.se.dam_service.repositories;

import ctu.cit.se.dam_service.entites.Dam;
import ctu.cit.se.dam_service.entites.DamType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IDamTypeRepository extends JpaRepository<DamType, UUID> {
}
