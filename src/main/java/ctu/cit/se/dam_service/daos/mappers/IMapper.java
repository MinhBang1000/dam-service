package ctu.cit.se.dam_service.daos.mappers;

public interface IMapper<S,D>{
    D convert(S source);
}
