package ctu.cit.se.dam_service.migrations.imples;

import ctu.cit.se.dam_service.entites.DamType;
import ctu.cit.se.dam_service.entites.River;
import ctu.cit.se.dam_service.migrations.IBaseInitData;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DamTypeInitData implements IBaseInitData<DamType> {

    @Override
    public List<DamType> getInitData() {
        return List.of(
                DamType.builder()
                        .name("Mặc định")
                        .description("Dữ liệu mặc định")
                        .code("dms-dam-type-default-code-1")
                        .build()
        );
    }
}
