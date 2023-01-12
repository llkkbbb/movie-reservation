package com.example.movie_reservation.service;

import com.example.movie_reservation.controller.main.dto.SearchMovieOrActorResponseDto;
import com.example.movie_reservation.domain.actor.Actor;
import com.example.movie_reservation.domain.actor.ActorRepository;
import com.example.movie_reservation.domain.movie.Movie;
import com.example.movie_reservation.domain.movie.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchService {

    private final ActorRepository actorRepository;
    private final MovieRepository movieRepository;

    @Transactional
    public SearchMovieOrActorResponseDto searchMovieOrActor(String keyword) {
        List<Actor> actors = actorRepository.findByFirstNameContainingOrLastNameContainingOrderByFirstName(keyword);
        List<Movie> movies = movieRepository.findByTitleContainingOrderByTitle(keyword);
        return SearchMovieOrActorResponseDto.of(movies, actors);
    }

}