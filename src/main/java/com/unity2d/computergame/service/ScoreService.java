package com.unity2d.computergame.service;


import com.unity2d.computergame.domain.Score;
import com.unity2d.computergame.dto.ScoreSaveRequestDto;
import com.unity2d.computergame.repository.ScoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class ScoreService {

    private final ScoreRepository scoreRepository;

    public Long save(ScoreSaveRequestDto requestDto){
        Score score = Score.builder()
                .name(requestDto.getName())
                .score(requestDto.getScore())
                .build();


        return scoreRepository.save(score).getId();

    }
    public List<Score> getScoresOrderedByScoreAsc() {
        return scoreRepository.findAllByOrderByScoreDesc();
    }


}
