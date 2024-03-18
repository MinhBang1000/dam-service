package ctu.cit.se.dam_service.dtos.responses.damschedules;

import com.fasterxml.jackson.annotation.JsonProperty;
import ctu.cit.se.dam_service.dtos.responses.dams.RetrieveDamResDTO;
import ctu.cit.se.dam_service.dtos.responses.damstatuses.RetrieveDamStatusResDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RetrieveDamScheduleShorterVersionResDTO {
    @JsonProperty("damScheduleId")
    private String id;
    @JsonProperty("damScheduleBeginAt")
    private LocalDateTime beginAt;
    @JsonProperty("damScheduleEndAt")
    private LocalDateTime endAt;
}