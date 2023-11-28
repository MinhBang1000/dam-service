package ctu.cit.se.dam_service.daos;

import java.util.List;
import java.util.UUID;

public interface IBaseDAO<S,D>{
    void create(S source);
    void update(S source);
    List<D> list();
    D retrieve(UUID sourceId);
    void delete(UUID sourceId);
}
