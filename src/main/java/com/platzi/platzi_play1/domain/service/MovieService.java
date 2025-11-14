package com.platzi.platzi_play1.domain.service;


import com.platzi.platzi_play1.domain.dto.MovieDto;
import com.platzi.platzi_play1.domain.dto.UpdateMovieDto;
import com.platzi.platzi_play1.domain.repository.MovieRepository;
import dev.langchain4j.agent.tool.Tool;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService (MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

     @Tool("Busca todas las peliculas que existan destro de la plataforma")
     public List<MovieDto> getAll() {
         return this.movieRepository.getAll();

     }

     public MovieDto getById(long id) {
        return this.movieRepository.getById(id);
     }

     public MovieDto add(MovieDto movieDto) {
        return this.movieRepository.save(movieDto);
     }

     public MovieDto update(long id, UpdateMovieDto updateMovieDto) {
        return this.movieRepository.update(id, updateMovieDto);
     }

     public void delete(long id) {
        this.movieRepository.delete(id);
     }



}
