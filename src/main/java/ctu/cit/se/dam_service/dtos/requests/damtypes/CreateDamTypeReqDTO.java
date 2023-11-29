package ctu.cit.se.dam_service.dtos.requests.damtypes;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CreateDamTypeReqDTO  {
    @JsonProperty("damTypeName")
    private String name;
    @JsonProperty("damTypeDescription")
    private String description;
}
