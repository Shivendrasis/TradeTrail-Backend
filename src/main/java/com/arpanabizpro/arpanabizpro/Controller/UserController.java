package com.arpanabizpro.arpanabizpro.Controller;

import com.arpanabizpro.arpanabizpro.Entity.UserEntity;
import com.arpanabizpro.arpanabizpro.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class UserController {


    @Autowired
    private UserService userService;


    //for user register
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserEntity userEntity){
        String result = userService.registerUser(userEntity);

        if(result.equals("User register successfully")){
            return ResponseEntity.ok(result);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserEntity userEntity){
        boolean isValid = userService.validateUser(userEntity.getUsername(), userEntity.getPassword());

        if(isValid){
            return ResponseEntity.ok("Login Successfully");
        }else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }
}
