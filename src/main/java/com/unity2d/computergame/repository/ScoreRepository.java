package com.unity2d.computergame.repository;

import com.unity2d.computergame.domain.Score;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ScoreRepository extends JpaRepository<Score, Long> {
    List<Score> findAllByOrderByScoreDesc();
    List<Score> findAllById(Long id);

}
