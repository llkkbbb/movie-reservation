package com.example.springbootmoviereservationsystem.controller.main.dto;

import com.example.springbootmoviereservationsystem.controller.actor.dto.ActorResponseDto;
import com.example.springbootmoviereservationsystem.controller.movie.dto.MovieResponseDto;
import com.example.springbootmoviereservationsystem.domain.actor.Actor;
import com.example.springbootmoviereservationsystem.domain.movie.Movie;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class SearchMovieOrActorResponseDto {

    private List<MovieResponseDto> movies;
    private List<ActorResponseDto> actors;

    @Builder
    public SearchMovieOrActorResponseDto(List<MovieResponseDto> movies, List<ActorResponseDto> actors) {
        this.movies = movies;
        this.actors = actors;
    }

    public static SearchMovieOrActorResponseDto of(List<Movie> movies, List<Actor> actors) {
        return SearchMovieOrActorResponseDto.builder()
                .movies(movies.stream()
                        .map(MovieResponseDto::of)
                        .collect(Collectors.toList()))
                .actors(actors.stream()
                        .map(actor -> ActorResponseDto.of(actor))
                        .collect(Collectors.toList()))
                .build();
    }
}