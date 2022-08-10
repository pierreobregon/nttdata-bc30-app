package com.nttdata.bc30.appbc30.exceptions;

public class ModelNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

	public ModelNotFoundException(String mensaje){
        super(mensaje);
    }
}
