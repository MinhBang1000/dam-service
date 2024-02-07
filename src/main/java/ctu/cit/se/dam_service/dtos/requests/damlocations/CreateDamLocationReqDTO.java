package ctu.cit.se.dam_service.dtos.requests.damlocations;

import com.fasterxml.jackson.annotation.JsonProperty;
import ctu.cit.se.dam_service.exceptions.customizes.annotations.ValidDateRange;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CreateDamLocationReqDTO {

    @NotNull(message = "The longitude of dam should not be null")
    @JsonProperty("damLocationLongitude")
    private String longitude;

    @NotNull(message = "The latitude of dam should not be null")
    @JsonProperty("damLocationLatitude")
    private String latitude;

    @NotBlank(message = "The dam id should not be null")
    @JsonProperty("damLocationDamId")
    private String damId;
}
