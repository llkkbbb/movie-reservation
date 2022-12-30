package com.example.springbootmoviereservationsystem.domain.movie;

import com.example.springbootmoviereservationsystem.controller.movie.dto.MovieResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @EntityGraph(value = "movieWithMoney")
    Page<MovieResponseDto> findByTitleLikeOrReleaseStatusEqualsOrderByTitle(String title,
                                                                ReleaseStatus status,
                                                                Pageable pageable);

    @EntityGraph(value = "movieWithMoney")
    Optional<Movie> findById(Long movieId);
}
