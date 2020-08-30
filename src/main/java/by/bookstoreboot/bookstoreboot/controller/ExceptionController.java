package by.bookstoreboot.bookstoreboot.controller;

import by.bookstoreboot.bookstoreboot.controller.exception.AccessException;
import by.bookstoreboot.bookstoreboot.controller.exception.InvalidUUIDUserApiKey;
import by.bookstoreboot.bookstoreboot.service.exception.AuthorInBookNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, String>> constraintException(ConstraintViolationException ex) {
        Map<String, String> stringStringMap = new HashMap<>();
        Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();

        for (ConstraintViolation<?> constraintViolation : constraintViolations) {
            stringStringMap.put(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage());
        }
        return new ResponseEntity<>(stringStringMap, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidUUIDUserApiKey.class)
    public ResponseEntity<String> constraintException(InvalidUUIDUserApiKey ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AccessException.class)
    public ResponseEntity<String> accessException(AccessException ae){
        return new ResponseEntity<>(ae.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AuthorInBookNotFoundException.class)
    public ResponseEntity<String> addressInBookExc(AuthorInBookNotFoundException addressExc){
        return new ResponseEntity<>(addressExc.getMessage(), HttpStatus.BAD_REQUEST);
    }

//    @Override
//    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//        return new ResponseEntity<>("Not supported media type", HttpStatus.BAD_REQUEST);
//    }
//
//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//                                                                  HttpHeaders headers,
//                                                                  HttpStatus status,
//                                                                  WebRequest request) {
//        Map<String, String> stringStringMap = new HashMap<>();
//        List<ObjectError> allErrors = ex.getBindingResult().getAllErrors();
//
//        for (ObjectError allError : allErrors) {
//            FieldError allError1 = (FieldError) allError;
//            stringStringMap.put(allError1.getField(), allError1.getDefaultMessage());
//        }
//        return new ResponseEntity<>(stringStringMap, HttpStatus.BAD_REQUEST);
//    }


}
