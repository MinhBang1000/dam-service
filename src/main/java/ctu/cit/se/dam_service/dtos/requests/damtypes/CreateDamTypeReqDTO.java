package ctu.cit.se.dam_service.dtos.requests.damtypes;

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
public class CreateDamTypeReqDTO {
    @JsonProperty("damName")
    private String name;
    @JsonProperty("damDescription")
    private String description;
}
