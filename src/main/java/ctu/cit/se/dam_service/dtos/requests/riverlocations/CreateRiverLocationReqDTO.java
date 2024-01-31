package ctu.cit.se.dam_service.dtos.requests.riverlocations;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CreateRiverLocationReqDTO {

    @NotNull(message = "The longtitude of river should not be null")
    @JsonProperty("riverLocationLongitude")
    private String longitude;

    @NotNull(message = "The latitude of river should not be null")
    @JsonProperty("riverLocationLatitude")
    private String latitude;

    @NotBlank(message = "The river id should not be null")
    @JsonProperty("riverLocationRiverId")
    private String riverId;
}
