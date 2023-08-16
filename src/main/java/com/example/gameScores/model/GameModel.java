package com.example.gameScores.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="game")
@Entity
public class GameModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer gameid;
    private String name;
    private String description;
}
