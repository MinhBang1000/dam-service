package ctu.cit.se.dam_service.dtos.responses.rivers;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RetrieveRiverResDTO {
    @JsonProperty("riverId")
    private String id;
    @JsonProperty("riverName")
    private String name;
    @JsonProperty("riverLocation")
    private String location;
}