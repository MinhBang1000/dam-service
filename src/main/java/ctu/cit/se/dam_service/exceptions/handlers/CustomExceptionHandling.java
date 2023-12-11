package ctu.cit.se.dam_service.exceptions.handlers;

import ctu.cit.se.dam_service.dtos.responses.errors.ErrorDetails;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class CustomExceptionHandling{
    @ExceptionHandler(value = {Exception.class})
    protected ResponseEntity<ErrorDetails> handleAllException(Exception ex, WebRequest request) throws Exception {
            ex.printStackTrace();
            return new ResponseEntity<>(ErrorDetails.builder().detail(request.getDescription(false)).createAt(LocalDateTime.now()).message(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
    }
}
