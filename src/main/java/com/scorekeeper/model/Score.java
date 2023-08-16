package com.scorekeeper.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="score", indexes = @Index(name="userIndex",columnList = "userId"))
@Entity
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long scoreId;
    @NonNull
    private Integer userId;
    @NonNull
    private Integer gameId;
    @NonNull
    private Integer score;
}
/* Score table created to maintain user scores for each game and times played
userID and gameID were not taken as primary keys as they may duplicate.
* */