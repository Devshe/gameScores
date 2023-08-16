package com.scorekeeper.database.seeders;

import com.scorekeeper.model.User;
import com.scorekeeper.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserSeeder {

    @Autowired
    private UserRepository userRepository;

    public void seed() {
        if(userRepository.findAll().size()==0){
            List<User> users = new ArrayList<>();
            users.add(new User("Harith", "meow123@gmail.com"));
            users.add(new User("Janith", "janith123@gmail.com"));
            users.add(new User("Kamal", "kamal123@gmail.com"));
            users.forEach((user)->{
                userRepository.save(user);
            });
        }
    }
}