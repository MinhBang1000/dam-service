package ctu.cit.se.dam_service.migrations.imples;

import ctu.cit.se.dam_service.dtos.requests.damtypes.CreateDamTypeReqDTO;
import ctu.cit.se.dam_service.migrations.IBaseInitData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class DamTypeInitData implements IBaseInitData<CreateDamTypeReqDTO> {
    @Override
    public List<CreateDamTypeReqDTO> getInitData() {
        return List.of(
                CreateDamTypeReqDTO.builder()
                        .name("Thông thường")
                        .description("Các loại cống / đập thường được sử dụng")
                        .build()
        );
    }
}
