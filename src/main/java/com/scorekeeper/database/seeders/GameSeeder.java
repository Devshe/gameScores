package com.scorekeeper.database.seeders;

import com.scorekeeper.model.Game;
import com.scorekeeper.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GameSeeder {
    @Autowired
    private GameRepository gameRepository;

    public void seed() {
        if(gameRepository.findAll().size()==0){
            List<Game>  games = new ArrayList<>();
            games.add(new Game("Football", "Lorem ipsum dolor sit amet, consectetur adipiscing " +
                    "elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."));
            games.add(new Game("VolleyBall", "Lorem ipsum dolor sit amet, consectetur adipiscing " +
                    "elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."));
            games.add(new Game("BasketBall", "Lorem ipsum dolor sit amet, consectetur adipiscing " +
                    "elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."));

            games.forEach((game)->{
                gameRepository.save(game);
            });
        }
    }
}
