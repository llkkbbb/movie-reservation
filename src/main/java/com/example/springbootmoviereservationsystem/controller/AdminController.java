package com.example.springbootmoviereservationsystem.controller;

import com.example.springbootmoviereservationsystem.controller.dto.request.consumer.ConsumerSaveAndUpdateRequestDto;
import com.example.springbootmoviereservationsystem.controller.dto.response.consumer.ConsumerDetailResponseDto;
import com.example.springbootmoviereservationsystem.service.ConsumerService;




<<<<<<< HEAD
import jakarta.validation.Valid;
=======
>>>>>>> feature/test
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

<<<<<<< HEAD
=======
import javax.validation.Valid;

>>>>>>> feature/test
@Valid
@RestController
@RequiredArgsConstructor
public class AdminController {

    private final ConsumerService consumerService;

    @GetMapping("/admin/consumers/{phone}")
    public ResponseEntity<ConsumerDetailResponseDto> consumerDetail(@Length(max = 11)
                                                                    @PathVariable(name = "phone") String phoneNumber) {
        ConsumerDetailResponseDto consumerDetailResponseDto =
                ConsumerDetailResponseDto.of(consumerService.findConsumer(phoneNumber));
        return ResponseEntity.status(HttpStatus.OK).body(consumerDetailResponseDto);
    }

    @PutMapping("/admin/consumer/{phone}")
    public ResponseEntity<Void> consumerUpdate(@PathVariable(name = "phone") String phoneNumber,
                                               @RequestBody ConsumerSaveAndUpdateRequestDto consumerSaveAndUpdateRequestDto) {
        consumerService.updateConsumer(phoneNumber, consumerSaveAndUpdateRequestDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
