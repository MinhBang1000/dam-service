package ctu.cit.se.dam_service.dtos.responses.damschedules;

import com.fasterxml.jackson.annotation.JsonProperty;
import ctu.cit.se.dam_service.dtos.responses.dams.RetrieveDamResDTO;
import ctu.cit.se.dam_service.dtos.responses.damstatuses.RetrieveDamStatusResDTO;
import ctu.cit.se.dam_service.dtos.responses.damtypes.RetrieveDamTypeResDTO;
import ctu.cit.se.dam_service.dtos.responses.rivers.RetrieveRiverResDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RetrieveDamScheduleResDTO {
    @JsonProperty("damScheduleId")
    private String id;
    @JsonProperty("damScheduleBeginAt")
    private LocalDateTime beginAt;
    @JsonProperty("damScheduleEndAt")
    private LocalDateTime endAt;
    @JsonProperty("damScheduleDescription")
    private String description;
    @JsonProperty("damScheduleIsLock")
    private Boolean isLock;
    @JsonProperty("damScheduleDam")
    private RetrieveDamResDTO dam;
    @JsonProperty("damScheduleDamStatus")
    private RetrieveDamStatusResDTO damStatus;
}