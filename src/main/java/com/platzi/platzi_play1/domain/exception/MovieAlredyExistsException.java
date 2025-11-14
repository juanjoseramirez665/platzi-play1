package com.platzi.platzi_play1.domain.exception;

public class MovieAlredyExistsException extends RuntimeException {
    public MovieAlredyExistsException(String movieTitle) {
        super("La pelicula" + movieTitle + " ya existe");
    }
}
