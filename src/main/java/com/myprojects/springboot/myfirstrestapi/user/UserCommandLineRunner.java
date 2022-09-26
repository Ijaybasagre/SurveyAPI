package com.myprojects.springboot.myfirstrestapi.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserCommandLineRunner implements CommandLineRunner {
    private UserRepository repository ;

    public UserCommandLineRunner(UserRepository userRepository){
        this.repository = userRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        repository.save(new UserDetails("userA","administrator"));
        repository.save(new UserDetails("userB","user"));
    }
}
