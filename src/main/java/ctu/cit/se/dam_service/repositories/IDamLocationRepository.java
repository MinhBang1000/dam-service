package ctu.cit.se.dam_service.repositories;

import ctu.cit.se.dam_service.entites.Dam;
import ctu.cit.se.dam_service.entites.DamLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IDamLocationRepository extends JpaRepository<DamLocation, UUID> {
    List<DamLocation> queryByDam(Dam dam);
}
