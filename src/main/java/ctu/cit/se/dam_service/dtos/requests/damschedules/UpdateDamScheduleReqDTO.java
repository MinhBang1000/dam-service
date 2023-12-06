package ctu.cit.se.dam_service.dtos.requests.damschedules;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class UpdateDamScheduleReqDTO  {
    @JsonProperty("damScheduleId")
    private String id;
    @JsonProperty("damScheduleBeginAt")
    private LocalDateTime beginAt;
    @JsonProperty("damScheduleEndAt")
    private LocalDateTime endAt;
    @JsonProperty("damScheduleDescription")
    private String description;
    @JsonProperty("damScheduleDamStatusId")
    private String damStatusId;
}
