package ctu.cit.se.dam_service.repositories;

import ctu.cit.se.dam_service.entites.DamStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDamStatusRepository extends JpaRepository<DamStatus, Long> {
}
