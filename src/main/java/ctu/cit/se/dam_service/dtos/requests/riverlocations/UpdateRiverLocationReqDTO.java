package ctu.cit.se.dam_service.dtos.requests.riverlocations;

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
public class UpdateRiverLocationReqDTO {
    @NotBlank(message = "The river location id should not be null")
    @JsonProperty("riverLocationId")
    private String id;

    @JsonProperty("riverLocationLongitude")
    private String longitude;

    @JsonProperty("riverLocationLatitude")
    private String latitude;
}
