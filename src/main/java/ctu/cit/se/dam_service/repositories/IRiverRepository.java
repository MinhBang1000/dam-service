package ctu.cit.se.dam_service.repositories;

import ctu.cit.se.dam_service.entites.River;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface IRiverRepository extends JpaRepository<River, UUID> {
    List<River> findByCode(String code);
}
