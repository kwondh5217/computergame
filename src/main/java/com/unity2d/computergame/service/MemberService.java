package com.unity2d.computergame.service;


import com.unity2d.computergame.domain.Member;
import com.unity2d.computergame.dto.MemberSaveRequestDto;
import com.unity2d.computergame.dto.MemberUpdateRequestDto;
import com.unity2d.computergame.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Long save(MemberSaveRequestDto requestDto){
        return memberRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, MemberUpdateRequestDto requestDto){
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
        member.update(requestDto.getName());

        return id;
    }

}
