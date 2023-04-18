package com.unity2d.computergame.controller;

import com.unity2d.computergame.domain.Member;
import com.unity2d.computergame.domain.Score;
import com.unity2d.computergame.dto.MemberSaveRequestDto;
import com.unity2d.computergame.dto.ScoreSaveRequestDto;
import com.unity2d.computergame.repository.ScoreRepository;
import com.unity2d.computergame.service.MemberService;
import com.unity2d.computergame.service.ScoreService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
class ScoreControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired private MemberService memberService;
    @Autowired private ScoreRepository scoreRepository;
    @Autowired private ScoreService scoreService;

    @Test
    @DisplayName("score가 등록된다")
    void scoreSave(){
        //given
        String name = "kwon";
        MemberSaveRequestDto requestDto = MemberSaveRequestDto.builder()
                .name(name).build();
        Long member = memberService.save(requestDto);
        Long score = 10L;
        String url = "http://localhost:" + port + "/score";

        ScoreSaveRequestDto scoreSaveRequestDto = ScoreSaveRequestDto.builder()
                .member(member)
                .score(score).build();
        //when
        scoreService.save(scoreSaveRequestDto);

        //then
        scoreRepository.flush();

        List<Score> scores = scoreRepository.findAll();

        assertThat(scores.get(0).getMember().getId()).isEqualTo(member);
        assertThat(scores.get(0).getScore()).isEqualTo(score);


    }

}