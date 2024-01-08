package ctu.cit.se.dam_service.dtos.responses.dams;

import com.fasterxml.jackson.annotation.JsonProperty;
import ctu.cit.se.dam_service.dtos.responses.damstatuses.RetrieveDamStatusResDTO;
import ctu.cit.se.dam_service.dtos.responses.damtypes.RetrieveDamTypeResDTO;
import ctu.cit.se.dam_service.dtos.responses.rivers.RetrieveRiverResDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RetrieveDamResDTO {
    @JsonProperty("damId")
    private String id;
    @JsonProperty("damName")
    private String name;
    @JsonProperty("damConstructedAt")
    private LocalDate constructedAt;
    @JsonProperty("damDescription")
    private String description;
    @JsonProperty("damHeight")
    private Double height;
    @JsonProperty("damCapacity")
    private Integer capacity;
    @JsonProperty("damLongtitude")
    private Double longtitude;
    @JsonProperty("damLatitude")
    private Double latitude;
    @JsonProperty("damType")
    private RetrieveDamTypeResDTO damType;
    @JsonProperty("damRiver")
    private RetrieveRiverResDTO river;
    @JsonProperty("damCurrentStatus")
    private RetrieveDamStatusResDTO damStatus;
}