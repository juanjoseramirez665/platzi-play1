package com.platzi.platzi_play1.web.exception;

import com.platzi.platzi_play1.domain.exception.MovieAlredyExistsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class RestExceptionHadler {

  @ExceptionHandler(MovieAlredyExistsException.class)
  public ResponseEntity<Error> handleException(MovieAlredyExistsException ex) {
     Error error = new Error( "movie-already-exists", ex.getMessage());
       return ResponseEntity.badRequest().body(error);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<List<Error>> handleException(MethodArgumentNotValidException ex) {
      List<Error> errors = new ArrayList<>();

      ex.getBindingResult().getFieldErrors().forEach(error -> {
          errors.add(new Error(error.getField(), error.getDefaultMessage()));
      });
      return ResponseEntity.badRequest().body(errors);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<Error> handleException(Exception ex) {
     Error error = new Error( "unknown-error", ex.getMessage());
     ex.printStackTrace();
     return ResponseEntity.internalServerError().body(error);
  }


}
