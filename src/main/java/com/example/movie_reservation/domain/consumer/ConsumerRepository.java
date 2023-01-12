package com.example.movie_reservation.domain.consumer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface ConsumerRepository extends JpaRepository<Consumer, Long> {
    boolean existsByNicknameOrPhoneNumber(String nickname, String phoneNumber);
}