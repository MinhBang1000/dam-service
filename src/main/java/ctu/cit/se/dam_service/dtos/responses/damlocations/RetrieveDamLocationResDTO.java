package ctu.cit.se.dam_service.dtos.responses.damlocations;

import com.fasterxml.jackson.annotation.JsonProperty;
import ctu.cit.se.dam_service.dtos.responses.dams.RetrieveDamResDTO;
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
public class RetrieveDamLocationResDTO {
    @JsonProperty("damLocationId")
    private String id;
    @JsonProperty("damLocationLongitude")
    private String longitude;
    @JsonProperty("damLocationLatitude")
    private String latitude;
    @JsonProperty("damLocationDam")
    private RetrieveDamResDTO dam;
}