package ctu.cit.se.dam_service.daos.validations;

public interface IValidation<T>{
    ValidationErrors isValid(T source);
}
