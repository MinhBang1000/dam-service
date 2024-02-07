package ctu.cit.se.dam_service.dtos.requests.damlocations;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UpdateDamLocationReqDTO {

    @NotBlank(message = "The dam location id should not be null")
    @JsonProperty("damLocationId")
    private String id;

    @JsonProperty("damLocationLongitude")
    private String longitude;

    @JsonProperty("damLocationLatitude")
    private String latitude;
}
