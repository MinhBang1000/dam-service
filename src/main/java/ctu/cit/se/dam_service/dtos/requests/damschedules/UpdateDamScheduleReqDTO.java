package ctu.cit.se.dam_service.dtos.requests.damschedules;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotBlank(message = "The dam schedule id should not be null")
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
