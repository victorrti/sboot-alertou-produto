package com.alertou.sboot_atom_produto.exception;

public class BusinessException extends RuntimeException{
    public BusinessException(String message){
        super(message);
    }
}
