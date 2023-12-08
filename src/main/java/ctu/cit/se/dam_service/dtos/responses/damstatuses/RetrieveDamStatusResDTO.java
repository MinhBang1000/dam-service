package ctu.cit.se.dam_service.dtos.responses.damstatuses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RetrieveDamStatusResDTO {
    @JsonProperty("damStatusId")
    private String id;
    @JsonProperty("damStatusName")
    private String name;
}