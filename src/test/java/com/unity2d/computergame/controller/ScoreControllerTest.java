package com.unity2d.computergame.controller;

import com.unity2d.computergame.domain.Score;
import com.unity2d.computergame.dto.ScoreSaveRequestDto;
import com.unity2d.computergame.repository.ScoreRepository;
import com.unity2d.computergame.service.ScoreService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import javax.transaction.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
class ScoreControllerTest {

    @LocalServerPort
    private int port;

    @Autowired private ScoreRepository scoreRepository;
    @Autowired private ScoreService scoreService;


}