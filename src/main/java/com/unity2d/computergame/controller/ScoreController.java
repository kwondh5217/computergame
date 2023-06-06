package com.unity2d.computergame.controller;


import com.unity2d.computergame.domain.Score;
import com.unity2d.computergame.dto.ScoreSaveRequestDto;
import com.unity2d.computergame.service.ScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ScoreController {

    private final ScoreService scoreService;

    @PostMapping("/score")
    public Long save(@RequestParam String name, @RequestParam int score) {

        ScoreSaveRequestDto dto = ScoreSaveRequestDto.builder()
                .name(name)
                .score(score)
                .build();

        return scoreService.save(dto);
    }

    @GetMapping("/score/all")
    public List<Score> findTopFiveScores(){
        List<Score> allScores = scoreService.getScoresOrderedByScoreAsc();
        return allScores.subList(0, Math.min(allScores.size(), 5));
    }
}
