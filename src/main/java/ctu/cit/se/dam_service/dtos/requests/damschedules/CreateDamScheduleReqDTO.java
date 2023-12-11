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
public class CreateDamScheduleReqDTO {

    @NotNull(message = "The begin date should not be null")
    @JsonProperty("damScheduleBeginAt")
    private LocalDateTime beginAt;

    @NotNull(message = "The end date should not be null")
    @JsonProperty("damScheduleEndAt")
    private LocalDateTime endAt;

    @JsonProperty("damScheduleDescription")
    private String description;

    @NotBlank(message = "The dam id should not be null")
    @JsonProperty("damScheduleDamId")
    private String damId;

    @NotBlank(message = "The dam status id should not be null")
    @JsonProperty("damScheduleDamStatusId")
    private String damStatusId;
}
