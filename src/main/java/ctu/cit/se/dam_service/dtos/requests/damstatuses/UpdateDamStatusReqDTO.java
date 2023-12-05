package ctu.cit.se.dam_service.dtos.requests.damstatuses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UpdateDamStatusReqDTO {
    @JsonProperty("damStatusId")
    private String id;
    @JsonProperty("damStatusName")
    private String name;
}
