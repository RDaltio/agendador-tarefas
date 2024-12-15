package com.rdaltio.agendadortarefas.infrastructure.exceptions;

import javax.naming.AuthenticationException;

public class UnauthorizedException extends AuthenticationException {
    public UnauthorizedException(String mensagem){
        super(mensagem);
    }

}
