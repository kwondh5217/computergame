package com.unity2d.computergame.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter
@NoArgsConstructor
@Entity
@Table(name = "score")
public class Score {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "score")
    private Long score;

    @Builder
    public Score(Member member, Long score) {
        this.member = member;
        this.score = score;
    }
}
