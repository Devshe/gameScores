package com.example.gameScores.controller;

import com.example.gameScores.model.ScoreModel;
import com.example.gameScores.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/score")
public class ScoreController {

    private final ScoreRepository scoreRepository;

    @Autowired
    public ScoreController(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
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
    public List<Object[]> getHighscoreByUserID(@PathVariable Long Id){
         return scoreRepository.findMaxScoresByUserId(Id);
    }

}
