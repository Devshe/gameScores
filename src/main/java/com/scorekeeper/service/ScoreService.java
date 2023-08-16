package com.scorekeeper.service;

import com.scorekeeper.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;



@Service
public class ScoreService {
    private final ScoreRepository scoreRepository;


    @Autowired
    public ScoreService(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    public HashMap<String,String> getHighscoresByUserId(Long userId){
        List <Object[]> highScores = scoreRepository.findMaxScoresByUserId(userId);
        HashMap<String,String> hashMap = new HashMap<>();
        for(Object[] ob:highScores){
            hashMap.put("Game Id: " + ob[1], "Score: " + ob[0]);
        }
        return hashMap;
    }

    public HashMap<String,String> getGameHighscores(Long userId){
        List <Object[]> highScores = scoreRepository.findTopScoresForGame(userId);
        HashMap<String,String> hashMap = new HashMap<>();
        for(Object[] ob:highScores){
            hashMap.put("User Id :" + ob[1], "Score: " + ob[0]);
        }
        return hashMap;
    }
}
