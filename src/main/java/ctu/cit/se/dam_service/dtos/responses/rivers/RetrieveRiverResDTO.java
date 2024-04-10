package ctu.cit.se.dam_service.dtos.responses.rivers;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RetrieveRiverResDTO {
    @JsonProperty("riverId")
    private String id;
    @JsonProperty("riverCode")
    private String code;
    @JsonProperty("riverName")
    private String name;
    @JsonProperty("riverLocation")
    private String location;
    @JsonProperty("riverLatitude")
    private String latitude;
    @JsonProperty("riverLongitude")
    private String longitude;
}