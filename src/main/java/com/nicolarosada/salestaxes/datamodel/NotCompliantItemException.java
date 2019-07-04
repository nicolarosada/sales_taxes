package com.nicolarosada.salestaxes.datamodel;

public class NotCompliantItemException extends RuntimeException {

    public NotCompliantItemException(String errorMessage) {
        super(errorMessage);
    }
}
