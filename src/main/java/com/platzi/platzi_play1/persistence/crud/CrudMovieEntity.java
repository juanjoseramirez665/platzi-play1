package com.platzi.platzi_play1.persistence.crud;

import com.platzi.platzi_play1.persistence.entity.MovieEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudMovieEntity  extends CrudRepository<MovieEntity, Long> {
}

