package com.unity2d.computergame.dto;


import com.unity2d.computergame.domain.Score;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ScoreSaveRequestDto {

    private String name;

    private int score;

    @Builder
    public ScoreSaveRequestDto(String name, int score) {
        this.name = name;
        this.score = score;
    }
}
