package com.platzi.platzi_play1.domain.dto;

import com.platzi.platzi_play1.domain.Genre;

import java.time.LocalDate;

public record MovieDto(
        Long id,
        String title,
        Integer duration,
        Genre genre,
        LocalDate releaseDate,
        Double rating

) {
}
