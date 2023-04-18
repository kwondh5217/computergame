package com.unity2d.computergame.repository;

import com.unity2d.computergame.domain.Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, Long> {
}
