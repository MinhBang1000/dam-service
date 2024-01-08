package ctu.cit.se.dam_service.daos.validations;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ValidationErrors {
    private Boolean status;
    private String message;
}
