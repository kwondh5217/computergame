package com.unity2d.computergame.dto;


import com.unity2d.computergame.domain.Score;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ScoreSaveRequestDto {

    private Long member;

    private Long score;

    @Builder
    public ScoreSaveRequestDto(Long member, Long score) {
        this.member = member;
        this.score = score;
    }
}
