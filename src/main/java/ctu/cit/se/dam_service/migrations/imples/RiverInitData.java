package ctu.cit.se.dam_service.migrations.imples;

import ctu.cit.se.dam_service.dtos.requests.rivers.CreateRiverReqDTO;
import ctu.cit.se.dam_service.migrations.IBaseInitData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class RiverInitData implements IBaseInitData<CreateRiverReqDTO> {
    @Override
    public List<CreateRiverReqDTO> getInitData() {
        return List.of(
                CreateRiverReqDTO.builder()
                        .name("Mặc định")
                        .location("Thông tin sông / kênh / rạch mặc định, hỗ trợ thay đổi sau khi tạo cống / đập nếu ta chưa biết về thông tin này")
                        .latitude("10,074983856980657")
                        .longitude("105,76771707341348")
                        .build()
        );
    }
}
