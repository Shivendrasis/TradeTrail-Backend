package com.arpanabizpro.arpanabizpro.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name= "users")
@Data
public class UserEntity {

    @Id
    @Column(name= "username")
    private String username;

    @Column(name = "password")
    private String password;

    private String email;

}
