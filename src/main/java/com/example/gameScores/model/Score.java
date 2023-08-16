package com.example.gameScores.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="score")
@Entity
public class Score {
    @Id
    private Integer userId;
    @Id
    private Integer id;
    private Integer score;

}
