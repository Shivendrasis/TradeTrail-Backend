package com.arpanabizpro.arpanabizpro.Repository;

import com.arpanabizpro.arpanabizpro.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserReposistory extends JpaRepository<UserEntity, String> {

    //findby username and password
    Optional<UserEntity> findByUsernameAndPassword(String username, String password);

    boolean existsByEmail(String email);
    boolean existsByUsername(String username);

}
