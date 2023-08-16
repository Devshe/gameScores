package com.scorekeeper.database.seeders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    private UserSeeder userSeeder;

    @Autowired
    private GameSeeder gameSeeder;

    @Override
    public void run(String... args) throws Exception {
        userSeeder.seed();
        gameSeeder.seed();
    }
}