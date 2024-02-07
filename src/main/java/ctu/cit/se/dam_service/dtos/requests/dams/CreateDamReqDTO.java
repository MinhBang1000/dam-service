package ctu.cit.se.dam_service.dtos.requests.dams;

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
public class CreateDamReqDTO {

    @NotBlank(message = "The dam name should not be blank")
    @JsonProperty("damName")
    private String name;

    @JsonProperty("damConstructedAt")
    private LocalDate constructedAt;

    @JsonProperty("damDescription")
    private String description;

    @NotNull(message = "The dam height should not be null")
    @JsonProperty("damHeight")
    private Double height;

    @JsonProperty("damCapacity")
    @NotNull(message = "The dam capacity should not be null")
    private Integer capacity;

    @NotNull(message = "The dam longitude should not be null")
    @JsonProperty("damLongitude")
    private Double longitude;

    @NotNull(message = "The dam latitude should not be null")
    @JsonProperty("damLatitude")
    private Double latitude;

    @NotBlank(message = "The dam type id should not be null")
    @JsonProperty("damTypeId")
    private String damTypeId;

    @NotBlank(message = "The dam river id should not be null")
    @JsonProperty("damRiverId")
    private String riverId;
}
