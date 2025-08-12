package com.arpanabizpro.arpanabizpro.Service.ProductServiceImpl;

import com.arpanabizpro.arpanabizpro.Entity.UserEntity;
import com.arpanabizpro.arpanabizpro.Repository.UserReposistory;
import com.arpanabizpro.arpanabizpro.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplimentation implements UserService {

    @Autowired
    private UserReposistory userReposistory;

    @Override
    public boolean validateUser(String username, String password) {
        return userReposistory.findByUsernameAndPassword(username, password).isPresent();
    }

    @Override
    public String registerUser(UserEntity user) {
        if (userReposistory.existsByUsername(user.getUsername())) {
            return "Username already exists!";
        }

        if (userReposistory.existsByEmail(user.getEmail())) {
            return "Email already exists!";
        }

        userReposistory.save(user);
        return "User registered successfully!";
    }

    @Override
    public String existByEmail(String email) {
        if (userReposistory.existsByEmail(email)) {
            return "Email already exists!";
        }
        return "Email available.";
    }

    @Override
    public String existByUsername(String username) {
        if (userReposistory.existsByUsername(username)) {
            return "Username already exists!";
        }
        return "Username available.";
    }
}
