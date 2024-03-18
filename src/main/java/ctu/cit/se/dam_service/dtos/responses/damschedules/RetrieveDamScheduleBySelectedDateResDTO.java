package ctu.cit.se.dam_service.dtos.responses.damschedules;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RetrieveDamScheduleBySelectedDateResDTO {
    @JsonProperty("damId")
    private String id;
    @JsonProperty("damName")
    private String name;
    @JsonProperty("damCurrentStatus")
    private String statusName;
    @JsonProperty("damLongitude")
    private Double longitude;
    @JsonProperty("damLatitude")
    private Double latitude;
    @JsonProperty("damSchedulesAtThisDate")
    private List<RetrieveDamScheduleShorterVersionResDTO> damSchedules;
}