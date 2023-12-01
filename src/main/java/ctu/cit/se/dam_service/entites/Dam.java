package ctu.cit.se.dam_service.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name = "dams")
public class Dam {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "dam_name", nullable = false)
    private String name;
    @Column(name = "dam_construction_date")
    private LocalDate constructedAt;
    @Column(name = "dam_height")
    private Double height;
    @Column(name = "dam_capacity")
    private Integer capacity;
    @Column(name = "dam_longtitude")
    private Double longtitude;
    @Column(name = "dam_latitude")
    private Double latitude;
    @Column(name = "dam_is_lock")
    private Boolean isLock;
    @ManyToOne
    @JoinColumn(name = "dam_type_id")
    private DamType damType;
    @ManyToOne
    @JoinColumn(name = "dam_river_id")
    private River river;
}
