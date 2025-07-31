package com.edigest.Bookstore.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edigest.Bookstore.DTO.LoginRequest;
import com.edigest.Bookstore.entity.User;
import com.edigest.Bookstore.service.UserService;



@RestController
@RequestMapping("/Login-page")
public class UserController{
    private final UserService userService;

    public UserController(UserService userSrevice){
        this.userService=userSrevice;
}

@PostMapping("/Register-User")
public ResponseEntity<String> register(@RequestBody User user){
  String result= userService.register(user);
   if (result.equals("User already exists!")) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result); // 409 Conflict
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(result); // 201 Created
        }
    }

@PostMapping("/login")
public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
                String result = userService.login(loginRequest.getEmail(), loginRequest.getPassword());

                if (result.equals("User already exists")) {
                 return ResponseEntity.status(HttpStatus.CONFLICT).body(result); // 409 Conflict
                } else {
                    return ResponseEntity.status(HttpStatus.CREATED).body(result); // 201 Created
                }
            }
}
            
        
        
    




