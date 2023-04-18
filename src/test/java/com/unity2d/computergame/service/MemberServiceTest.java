package com.unity2d.computergame.service;

import com.unity2d.computergame.domain.Member;
import com.unity2d.computergame.dto.MemberSaveRequestDto;
import com.unity2d.computergame.dto.MemberUpdateRequestDto;
import com.unity2d.computergame.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
class MemberServiceTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberService memberService;


    @BeforeEach
    void allClear(){
        memberRepository.deleteAll();
    }
    @Test
    @DisplayName("member가 등록된다")
    void memberSave(){
        //given
        String name = "kwon";
        MemberSaveRequestDto requestDto = MemberSaveRequestDto.builder()
                .name(name).build();

        String url = "http://localhost:" + port + "/member";
        //when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Member> members = memberRepository.findAll();
        assertThat(members.get(0).getName()).isEqualTo(name);

    }

    @Test
    @DisplayName("member가 수정된다")
    void memberUpdate(){
        //given
        Member savedMember = memberRepository.save(Member.builder()
                .name("kwon")
                .build());
        Long updateId = savedMember.getId();
        String expectedName = "kim";
        MemberUpdateRequestDto requestDto = MemberUpdateRequestDto.builder().name(expectedName).build();

        //when
        memberService.update(updateId, requestDto);

        //then
        List<Member> all = memberRepository.findAll();
        assertThat(all.get(0).getName()).isEqualTo(expectedName);
    }
}