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
public class CreateDamTypeReqDTO  {

    @NotBlank(message = "The dam type name should not be blank")
    @JsonProperty("damTypeName")
    private String name;

    @NotBlank(message = "The dam description should not be blank")
    @JsonProperty("damTypeDescription")
    private String description;
}
