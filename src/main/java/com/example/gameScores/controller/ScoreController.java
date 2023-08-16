package com.example.gameScores.controller;

import com.example.gameScores.model.UserModel;
import com.example.gameScores.repository.ScoreRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/score")
public class ScoreController {

    private final ScoreRepository scoreRepository;

    public ScoreController(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    @PostMapping("")
    public String create(@RequestBody UserModel userModel){
        scoreRepository.save(userModel);
        return "success";
    }
}
