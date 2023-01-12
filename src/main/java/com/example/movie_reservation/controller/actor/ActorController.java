package com.example.movie_reservation.controller.actor;

import com.example.movie_reservation.controller.actor.dto.ActorRequestDto;
import com.example.movie_reservation.controller.actor.dto.ActorResponseDto;
import com.example.movie_reservation.service.actor.ActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class ActorController {

    private final ActorService actorService;

    @PostMapping("/actors")
    public ResponseEntity<ActorResponseDto> createActor(@Valid @RequestBody ActorRequestDto actorRequestDto) {
        ActorResponseDto actorResponseDto = actorService.saveActor(actorRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(actorResponseDto);
    }
}