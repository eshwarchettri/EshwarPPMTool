package com.eshwar.ppmt.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MapErrorValidationService {

    public ResponseEntity<?> getMapErrorsValidation(List<FieldError> fieldErrorList) {
            Map<String, String> stringMap = fieldErrorList.stream().
                    collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
            return new ResponseEntity<>(stringMap, HttpStatus.BAD_REQUEST);
    }
}
