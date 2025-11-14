package com.platzi.platzi_play1.domain.dto;

import com.platzi.platzi_play1.domain.Genre;

import java.time.LocalDate;

public record UpdateMovieDto(
        String title,
        LocalDate releaseDate,
        Double rating

) {
}
