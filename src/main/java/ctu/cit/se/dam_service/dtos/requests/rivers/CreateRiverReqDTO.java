package ctu.cit.se.dam_service.dtos.requests.rivers;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CreateRiverReqDTO  {

    @NotBlank(message = "The river name should not be blank")
    @JsonProperty("riverName")
    private String name;
    @NotBlank(message = "The river location should not be blank")
    @JsonProperty("riverLocation")
    private String location;
    @NotBlank(message = "The river latitude should not be blank")
    @JsonProperty("riverLatitude")
    private String latitude;
    @NotBlank(message = "The river longitude should not be blank")
    @JsonProperty("riverLongitude")
    private String longitude;
    @NotBlank(message = "The river level should not be blank")
    @JsonProperty("riverLevel")
    private String level;
    @NotNull(message = "The river length should not be blank")
    @JsonProperty("riverLength")
    private Double length;
    @NotNull(message = "The river width should not be blank")
    @JsonProperty("riverWidth")
    private Double width;
    @NotBlank(message = "The river address should not be blank")
    @JsonProperty("riverAddress")
    private String address;
    @JsonProperty("riverNearestProcessingAt")
    private LocalDate nearestProcessingAt;


}
