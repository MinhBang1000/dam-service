package ctu.cit.se.dam_service.dtos.responses.riverlocations;

import com.fasterxml.jackson.annotation.JsonProperty;
import ctu.cit.se.dam_service.dtos.responses.dams.RetrieveDamResDTO;
import ctu.cit.se.dam_service.dtos.responses.rivers.RetrieveRiverResDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RetrieveRiverLocationResDTO {
    @JsonProperty("riverLocationId")
    private String id;
    @JsonProperty("riverLocationLongitude")
    private String longitude;
    @JsonProperty("riverLocationLatitude")
    private String latitude;
    @JsonProperty("riverLocationRiver")
    private RetrieveRiverResDTO river;
}