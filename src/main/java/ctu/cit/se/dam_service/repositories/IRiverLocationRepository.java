package ctu.cit.se.dam_service.repositories;

import ctu.cit.se.dam_service.entites.River;
import ctu.cit.se.dam_service.entites.RiverLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IRiverLocationRepository extends JpaRepository<RiverLocation, UUID> {
    List<RiverLocation> queryByRiver(River river);
}
