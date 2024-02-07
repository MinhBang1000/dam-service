package ctu.cit.se.dam_service.dtos.requests.dams;

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
public class UpdateDamReqDTO  {
    @NotBlank(message = "The dam id should not be null")
    @JsonProperty("damId")
    private String id;
    @JsonProperty("damName")
    private String name;
    @JsonProperty("damConstructedAt")
    private LocalDate constructedAt;
    @JsonProperty("damDescription")
    private String description;
    @JsonProperty("damHeight")
    private Double height;
    @JsonProperty("damCapacity")
    private Integer capacity;
    @JsonProperty("damLongitude")
    private Double longitude;
    @JsonProperty("damLatitude")
    private Double latitude;
    @JsonProperty("damTypeId")
    private String damTypeId;
    @JsonProperty("damRiverId")
    private String riverId;
}
