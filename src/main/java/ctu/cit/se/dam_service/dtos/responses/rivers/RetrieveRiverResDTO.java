package ctu.cit.se.dam_service.dtos.responses.rivers;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RetrieveRiverResDTO {
    @JsonProperty("riverId")
    private String id;
    @JsonProperty("riverName")
    private String name;
    @JsonProperty("riverCode")
    private String code;
    @JsonProperty("riverLocation")
    private String location;
    @JsonProperty("riverLatitude")
    private String latitude;
    @JsonProperty("riverLongitude")
    private String longitude;
    @JsonProperty("riverLevel")
    private String level;
    @JsonProperty("riverAddress")
    private String address;
    @JsonProperty("riverNearestProcessingAt")
    private LocalDate nearestProcessingAt;
    @JsonProperty("riverLength")
    private Double length;
    @JsonProperty("riverWidth")
    private Double width;
}