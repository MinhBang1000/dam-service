package ctu.cit.se.dam_service.migrations.imples;

import ctu.cit.se.dam_service.entites.River;
import ctu.cit.se.dam_service.migrations.IBaseInitData;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class RiverInitData implements IBaseInitData<River> {
    @Override
    public List<River> getInitData() {
        return List.of(
                River.builder()
                        .name("Mặc định")
                        .code("dms-river-default-code-1")
                        .latitude("105.7808084752133")
                        .longitude("10.024116454461662")
                        .location("Dữ liệu mặc định khi thông tin sông của cống đập bị xóa mà chưa được phục hồi")
                        .nearestProcessingAt(LocalDate.now())
                        .width(0.0)
                        .length(0.0)
                        .level("0")
                        .address("Dữ liệu mặc định")
                        .build()
        );
    }
}
