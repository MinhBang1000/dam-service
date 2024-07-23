package ctu.cit.se.dam_service.dtos.requests.rivers;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UpdateRiverReqDTO {

    @NotBlank(message = "The river id should not be null")
    @JsonProperty("riverId")
    private String id;

    @JsonProperty("riverName")
    private String name;

    @JsonProperty("riverLocation")
    private String location;

    @JsonProperty("riverLatitude")
    private String latitude;

    @JsonProperty("riverLongitude")
    private String longitude;

    @JsonProperty("riverLevel")
    private String level;

    @JsonProperty("riverLength")
    private Double length;

    @JsonProperty("riverWidth")
    private Double width;

    @JsonProperty("riverAddress")
    private String address;

    @JsonProperty("riverNearestProcessingAt")
    private LocalDate nearestProcessingAt;
}
