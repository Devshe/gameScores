package com.example.gameScores.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="score")
@Entity
public class ScoreModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long scoreId;
    private Integer userId;
    private Integer gameId;
    private Integer score;
}
