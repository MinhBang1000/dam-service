package ctu.cit.se.dam_service.dtos.requests.rivers;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CreateRiverReqDTO {
    @JsonProperty("riverName")
    private String name;
    @JsonProperty("riverLocation")
    private String location;
}
