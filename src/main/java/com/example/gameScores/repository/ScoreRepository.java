package com.example.gameScores.repository;

import com.example.gameScores.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends JpaRepository<UserModel, Integer> {
}
