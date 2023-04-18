package com.unity2d.computergame.repository;

import com.unity2d.computergame.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
