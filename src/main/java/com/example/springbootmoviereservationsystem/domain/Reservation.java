package com.example.springbootmoviereservationsystem.domain;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED, staticName = "of")
public class Reservation {

    private final Consumer consumer;
    private final int audienceCount;
    private final Screening screening;
    private final Long fee;

}