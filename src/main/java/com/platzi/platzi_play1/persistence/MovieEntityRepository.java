package com.platzi.platzi_play1.persistence;

import com.platzi.platzi_play1.domain.dto.MovieDto;
import com.platzi.platzi_play1.domain.dto.UpdateMovieDto;
import com.platzi.platzi_play1.domain.repository.MovieRepository;
import com.platzi.platzi_play1.persistence.crud.CrudMovieEntity;
import com.platzi.platzi_play1.persistence.entity.MovieEntity;
import com.platzi.platzi_play1.persistence.mapper.MovieMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class MovieEntityRepository implements MovieRepository {

    private final CrudMovieEntity crudMovieEntity;
    private final MovieMapper movieMapper;

    public MovieEntityRepository(CrudMovieEntity crudMovieEntity, MovieMapper movieMapper) {
        this.crudMovieEntity = crudMovieEntity;
        this.movieMapper = movieMapper;
    }

    @Override
    public List<MovieDto> getAll() {
        return this.movieMapper.toDtos(this.crudMovieEntity.findAll());
    }

    @Override
    public MovieDto getById(long id) {
        MovieEntity movieEntity = this.crudMovieEntity.findById(id).orElse(null);
        return movieMapper.toDto(movieEntity);
    }

    @Override
    public MovieDto save(MovieDto movieDto) {
        // Convertimos el DTO a entidad
        MovieEntity movieEntity = this.movieMapper.toEntity(movieDto);

        // Establecemos el estado por defecto ("D" = disponible)
        movieEntity.setEstado("D");

        // Guardamos y devolvemos el resultado como DTO
        MovieEntity savedEntity = this.crudMovieEntity.save(movieEntity);
        return this.movieMapper.toDto(savedEntity);
    }

    @Override
    public void delete(long id) {
        // Eliminación lógica (marca el registro como inactivo)
        this.crudMovieEntity.findById(id).ifPresent(movie -> {
            movie.setEstado("I"); // "I" = inactiva
            this.crudMovieEntity.save(movie);
        });
    }

    @Override
    public MovieDto update(long id, UpdateMovieDto updateMovieDto) {
        MovieEntity movieEntity = this.crudMovieEntity.findById(id).orElse(null);

       if(movieEntity == null) return null;

       this.movieMapper.updateEntityFromDto(updateMovieDto, movieEntity);
        return this.movieMapper.toDto(this.crudMovieEntity.save(movieEntity));

    }



}
