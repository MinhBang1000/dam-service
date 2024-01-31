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
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "rivers")
@Builder
public class River {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "river_name", nullable = false)
    private String name;
    @Column(name = "river_location", nullable = false)
    private String location;
    @OneToMany(mappedBy = "river", cascade = CascadeType.ALL)
    private List<Dam> dams = new ArrayList<>();
    @OneToMany(mappedBy = "river", cascade = CascadeType.ALL)
    private List<RiverLocation> riverLocations = new ArrayList<>();
}
