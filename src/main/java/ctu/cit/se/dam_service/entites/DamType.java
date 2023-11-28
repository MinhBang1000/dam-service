package ctu.cit.se.dam_service.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "dam_types")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DamType {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "dam_type_name", nullable = false)
    private String name;
    @Column(name = "dam_type_description")
    private String description;
    @OneToMany(mappedBy = "damType", cascade = CascadeType.ALL)
    List<Dam> dams = new ArrayList<>();
}
