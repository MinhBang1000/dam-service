package ctu.cit.se.dam_service.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name = "dam_locations")
public class DamLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "dam_location_longitude", nullable = false)
    private String longitude;
    @Column(name = "dam_location_latitude", nullable = false)
    private String latitude;
    @ManyToOne
    @JoinColumn(name = "dam_id")
    private Dam dam;
}
