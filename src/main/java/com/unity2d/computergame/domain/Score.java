package com.unity2d.computergame.domain;


import com.unity2d.computergame.repository.ScoreRepository;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;


@Getter
@NoArgsConstructor
@Entity
@Table(name = "score")
public class Score {

    @Id @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "score")
    private int score;

    @Builder
    public Score(String name, int score) {
        this.name = name;
        this.score = score;
    }

}
