package ctu.cit.se.dam_service.dtos.responses.damtypes;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RetrieveDamTypeResDTO {
    @JsonProperty("damTypeId")
    private String id;
    @JsonProperty("damTypeCode")
    private String code;
    @JsonProperty("damTypeName")
    private String name;
    @JsonProperty("damTypeDescription")
    private String description;
}