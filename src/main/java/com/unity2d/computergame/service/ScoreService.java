package com.unity2d.computergame.service;


import com.unity2d.computergame.domain.Member;
import com.unity2d.computergame.domain.Score;
import com.unity2d.computergame.dto.ScoreSaveRequestDto;
import com.unity2d.computergame.repository.MemberRepository;
import com.unity2d.computergame.repository.ScoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class ScoreService {

    private final MemberRepository memberRepository;
    private final ScoreRepository scoreRepository;

    public Long save(ScoreSaveRequestDto requestDto){
        Member member = memberRepository.findById(requestDto.getMember())
                .orElseThrow(() -> new IllegalArgumentException("Invalid Member id = " + requestDto.getMember()));
        Score score = Score.builder()
                .member(member)
                .score(requestDto.getScore())
                .build();

        return scoreRepository.save(score).getId();
    }

}
