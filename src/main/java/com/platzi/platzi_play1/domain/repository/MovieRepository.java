package com.platzi.platzi_play1.domain.repository;

import com.platzi.platzi_play1.domain.dto.MovieDto;
import com.platzi.platzi_play1.domain.dto.UpdateMovieDto;

import java.util.List;

/**
 * Interfaz del dominio que define las operaciones disponibles
 * para manejar películas en el sistema.
 *
 * Implementada por la clase MovieEntityRepository en la capa de persistencia.
 */
public interface MovieRepository {

    /**
     * Obtiene todas las películas registradas.
     *
     * @return lista de objetos MovieDto
     */
    List<MovieDto> getAll();

    /**
     * Busca una película por su ID.
     *
     * @param id identificador único de la película
     * @return MovieDto con los datos de la película, o null si no existe
     */
    MovieDto getById(long id);

    /**
     * Guarda o actualiza una película.
     *
     * @param movieDto datos de la película
     * @return la película guardada en formato MovieDto
     */
    MovieDto save(MovieDto movieDto);

    /**
     * Elimina lógicamente una película (marca su estado como "I" = inactiva).
     *
     * @param id identificador de la película a eliminar
     */
    void delete(long id);

    MovieDto update(long id, UpdateMovieDto updateMovieDto);


}
