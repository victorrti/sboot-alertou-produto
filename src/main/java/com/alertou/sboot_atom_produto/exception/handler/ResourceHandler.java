package com.alertou.sboot_atom_produto.exception.handler;

import com.alertou.sboot_atom_produto.dto.ErrorResponseDto;
import com.alertou.sboot_atom_produto.exception.BadRequestException;
import com.alertou.sboot_atom_produto.exception.BusinessException;
import com.alertou.sboot_atom_produto.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
@RestControllerAdvice
public class ResourceHandler {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDto> badRequestException(MethodArgumentNotValidException m) {

        Map<String, String> messages = new HashMap<>();
        m.getBindingResult().getAllErrors().forEach(error -> {
            String field = ((FieldError) error).getField();
            String defaultMessage = error.getDefaultMessage();
            messages.put(field, defaultMessage);
        });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorResponseDto.builder()
                .message(Arrays.toString(messages.entrySet().toArray()))
                .httpStatus(HttpStatus.BAD_REQUEST)
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .build());
    }
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponseDto> bussinesException(BusinessException businessException){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ErrorResponseDto.builder()
                .message(businessException.getMessage())
                .httpStatus(HttpStatus.CONFLICT)
                .statusCode(HttpStatus.CONFLICT.value())
                .build());
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponseDto> notFoundException(NotFoundException notFoundException){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ErrorResponseDto.builder()
                .message(notFoundException.getMessage())
                .httpStatus(HttpStatus.NOT_FOUND)
                .statusCode(HttpStatus.NOT_FOUND.value())
                .build());

    }


}
