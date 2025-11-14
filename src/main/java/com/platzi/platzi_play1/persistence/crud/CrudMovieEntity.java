package com.platzi.platzi_play1.persistence.crud;

import com.platzi.platzi_play1.persistence.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudMovieEntity extends JpaRepository<MovieEntity, Long> {

    // El nombre del método DEBE coincidir con el nombre del atributo en MovieEntity
    MovieEntity findFirstByTitulo(String titulo);
}
