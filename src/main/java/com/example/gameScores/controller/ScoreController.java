package com.example.gameScores.controller;

import com.example.gameScores.model.ScoreModel;
import com.example.gameScores.repository.ScoreRepository;
import com.example.gameScores.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/score")
public class ScoreController {

    private final ScoreRepository scoreRepository;
    private final ScoreService scoreService;

    @Autowired
    public ScoreController(ScoreRepository scoreRepository, ScoreService scoreService) {
        this.scoreRepository = scoreRepository;
        this.scoreService = scoreService;
    }

    @PostMapping("")
    public String createScore(@RequestBody ScoreModel scoreModel){
        scoreRepository.save(scoreModel);
        return "success";
    }

    @GetMapping("")
    public List<ScoreModel> getAllScore(){
        return scoreRepository.findAll();
    }

    @GetMapping("/{Id}")
    public ScoreModel getSingleData(@PathVariable Long Id){
        Optional<ScoreModel> scoreModel = scoreRepository.findById(Id);
        return scoreModel.get();
    }

    @GetMapping("/highScore/{Id}")
    public HashMap<String,String> getHighscoresByUserID(@PathVariable Long Id){
         return scoreService.getHighscoresByUserId(Id);

    }

    @GetMapping("/gamesHighScores/{Id}")
    public HashMap<String,String> getGameHighscores(@PathVariable Long Id) {
        return scoreService.getGameHighscores(Id);
    }
}
