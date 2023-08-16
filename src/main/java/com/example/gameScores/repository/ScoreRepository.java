package com.example.gameScores.repository;

import com.example.gameScores.model.ScoreModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreRepository extends JpaRepository<ScoreModel, Long> {
    @Query(value = "SELECT MAX(s.score) AS maxScore, s.game_id " +
            "FROM score s " +
            "WHERE s.user_id = :userId " +
            "GROUP BY s.game_id", nativeQuery = true)
    List<Object[]> findMaxScoresByUserId(@Param("userId") Long userId);

    @Query(value = "SELECT score, user_id " +
            "FROM score " +
            "WHERE game_id = :gameId " +
            "ORDER BY score DESC " +
            "LIMIT 10", nativeQuery = true)
    List<Object[]> findTopScoresForGame(@Param("gameId") Long gameId);
}
