package com.arpanabizpro.arpanabizpro.Service;

import com.arpanabizpro.arpanabizpro.Entity.UserEntity;
import com.arpanabizpro.arpanabizpro.Repository.UserReposistory;
import org.springframework.beans.factory.annotation.Autowired;

public interface UserService {

    boolean validateUser(String username, String password);

    String registerUser(UserEntity user);

    String existByEmail(String email);

    String existByUsername(String username);
}
