package com.scorekeeper.controller;

import com.scorekeeper.model.Score;
import com.scorekeeper.repository.ScoreRepository;
import com.scorekeeper.service.ScoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Optional;

@RestController
@RequestMapping("scores")
public class ScoreController {

    private final ScoreRepository scoreRepository;
    private final ScoreService scoreService;
    private final Logger logger = LoggerFactory.getLogger(ScoreController.class);

    @Autowired
    public ScoreController(ScoreRepository scoreRepository, ScoreService scoreService) {
        this.scoreRepository = scoreRepository;
        this.scoreService = scoreService;
    }
    
    @PostMapping()
    public String createScore(@RequestBody Score score){
        try {
            scoreRepository.save(score);
            return "user score saved successfully";
        } catch (Exception e){
            logger.error("Fail to save user score - reason : " + e.getMessage());
            return "Saving user score unsuccessful!";
        }
    }

    @GetMapping("/{id}")
    public Score getSingleData(@PathVariable Long id){
        Optional<Score> scoreModel = scoreRepository.findById(id);
        return scoreModel.get();
    }

    //Get user's highest scores in each game
    @GetMapping("/highScores/{id}")
    public HashMap<String,String> getHighScoresByUserID(@PathVariable Long Id){
         return scoreService.getHighscoresByUserId(Id);
    }

    //Retrieve a game's top ten highest scores
    @GetMapping("/gamesHighScores/{id}")
    public HashMap<String,String> getGameHighScores(@PathVariable Long Id) {
        return scoreService.getGameHighscores(Id);
    }
}
