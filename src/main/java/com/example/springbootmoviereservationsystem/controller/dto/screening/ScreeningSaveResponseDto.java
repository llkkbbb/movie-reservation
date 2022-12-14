package com.example.springbootmoviereservationsystem.controller.dto.screening;

import com.example.springbootmoviereservationsystem.controller.dto.movie.MovieResponseDto;
import com.example.springbootmoviereservationsystem.domain.Screening;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@RequiredArgsConstructor
public class ScreeningSaveResponseDto {

    @JsonProperty("screening_id")
    private final Long id; // 상영 순번

    @JsonProperty("movie")
    private final MovieResponseDto.MovieDto movieDto; // 영화 정보

    @JsonProperty("when")
    private final LocalDateTime whenScreened; // 상영 시간

    public static ScreeningSaveResponseDto of(Screening savedScreening) {
        return ScreeningSaveResponseDto.builder()
                .id(savedScreening.getId())
                .movieDto(MovieResponseDto.MovieDto.of(savedScreening.getMovie()))
                .whenScreened(savedScreening.getWhenScreened())
                .build();
    }
}
