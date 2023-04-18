package com.unity2d.computergame.controller;


import com.unity2d.computergame.dto.ScoreSaveRequestDto;
import com.unity2d.computergame.service.ScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ScoreController {

    private final ScoreService scoreService;

    @PostMapping("/score")
    public Long save(@RequestBody ScoreSaveRequestDto requestDto) {
        return scoreService.save(requestDto);
    }
}
