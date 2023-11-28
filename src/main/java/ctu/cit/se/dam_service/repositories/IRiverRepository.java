package ctu.cit.se.dam_service.repositories;

import ctu.cit.se.dam_service.entites.River;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IRiverRepository extends JpaRepository<River, UUID> {
}
