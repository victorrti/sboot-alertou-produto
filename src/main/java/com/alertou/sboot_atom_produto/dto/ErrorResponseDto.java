package com.alertou.sboot_atom_produto.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorResponseDto {
    private String message;
    private HttpStatus httpStatus;
    private int statusCode;
}
