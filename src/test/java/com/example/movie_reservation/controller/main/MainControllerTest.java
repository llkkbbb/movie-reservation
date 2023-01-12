package com.example.movie_reservation.controller.main;

import com.example.movie_reservation.controller.main.dto.SearchMovieOrActorResponseDto;
import com.example.movie_reservation.domain.actor.Actor;
import com.example.movie_reservation.domain.movie.Movie;
import com.example.movie_reservation.fixture.CreateEntity;
import com.example.movie_reservation.service.SearchService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MainController.class)
class MainControllerTest {

    @MockBean
    private SearchService searchService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    @DisplayName("검색 기능(영화, 배우) 테스트")
    void searchMovieOrActor() throws Exception {
        // when
        List<Actor> actors = List.of(CreateEntity.createActor());
        List<Movie> movies = List.of(CreateEntity.createMovie());

        SearchMovieOrActorResponseDto searchMovieOrActorResponseDto = SearchMovieOrActorResponseDto.of(movies, actors);
        given(searchService.searchMovieOrActor(any())).willReturn(searchMovieOrActorResponseDto);

        // when && then
        mockMvc.perform(get("/search")
                .queryParam("keyword", "any"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(mapper.writeValueAsString(searchMovieOrActorResponseDto)));

        verify(searchService).searchMovieOrActor(any());
    }
}