package ctu.cit.se.dam_service.dtos.requests.damtypes;

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
public class UpdateDamTypeReqDTO  {

    @NotBlank(message = "The dam type id should not be null")
    @JsonProperty("damTypeId")
    private String id;

    @JsonProperty("damTypeName")
    private String name;

    @JsonProperty("damTypeDescription")
    private String description;
}
