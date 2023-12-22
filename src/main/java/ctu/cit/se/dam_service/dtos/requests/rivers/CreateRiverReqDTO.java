package ctu.cit.se.dam_service.dtos.requests.rivers;

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
public class CreateRiverReqDTO  {

    @NotBlank(message = "The river name should not be blank")
    @JsonProperty("riverName")
    private String name;

    @NotBlank(message = "The river location should not be blank")
    @JsonProperty("riverLocation")
    private String location;
}
