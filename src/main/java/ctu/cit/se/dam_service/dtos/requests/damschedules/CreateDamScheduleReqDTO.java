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
public class CreateDamScheduleReqDTO {
    @JsonProperty("damScheduleBeginAt")
    private LocalDateTime beginAt;
    @JsonProperty("damScheduleEndAt")
    private LocalDateTime endAt;
    @JsonProperty("damScheduleDamId")
    private String damId;
    @JsonProperty("damScheduleDamStatusId")
    private String damStatusId;
}
