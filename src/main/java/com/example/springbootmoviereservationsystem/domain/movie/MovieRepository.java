package com.example.springbootmoviereservationsystem.domain.movie;

import com.example.springbootmoviereservationsystem.controller.movie.MovieDtoProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query(value = "select distinct " +
            "m.title as title, " +
            "m.fee as fee, " +
            "m.runningTime as runningTime, " +
            "m.releaseStatus as releaseStatus " +
            "from Movie m " +
            "where m.title like :title% " +
            "and m.releaseStatus =:status")
    Page<MovieDtoProjection> findByTitleLikeAndReleaseMovie(@Param("title") String title,
                                                            @Param("status") ReleaseStatus status,
                                                            Pageable pageable);

    @EntityGraph(value = "movieWithMoney")
    Optional<Movie> findById(Long movieId);
}