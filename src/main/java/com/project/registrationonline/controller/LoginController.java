package com.project.registrationonline.controller;


import com.project.registrationonline.model.Login;
import com.project.registrationonline.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin (origins = "http://localhost:3000")
@RequestMapping("/api/log")
public class LoginController {
    @Autowired
    private final LoginService loginService;

    
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    // Create
    @CrossOrigin (origins = "http://localhost:3000")
    @PostMapping("/add")
    public ResponseEntity<Login> addLogin(@RequestBody Login login) {
        try {
            Login newLogin = loginService.saveLogin(login);
            return new ResponseEntity<>(newLogin, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Read all logins
    @CrossOrigin (origins = "http://localhost:3000")
    @GetMapping("/all")
    public ResponseEntity<List<Login>> getAllLogins() {
        List<Login> logins = loginService.getAllLogins();
        if (logins.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(logins, HttpStatus.OK);
    }

    // Read one login by ID
    @CrossOrigin (origins = "http://localhost:3000")
    @GetMapping("/{logId}")
    public ResponseEntity<Login> getLoginById(@PathVariable("logId") Long logId) {
        Optional<Login> login = loginService.getLoginById(logId);
        return login.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update
    @CrossOrigin (origins = "http://localhost:3000")
    @PutMapping("/update/{logId}")
    public ResponseEntity<Login> updateLogin(@PathVariable("logId") Long logId, @RequestBody Login loginDetails) {
        Login updatedLogin = loginService.updateLogin(logId, loginDetails);
        if (updatedLogin != null) {
            return new ResponseEntity<>(updatedLogin, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete
    @CrossOrigin (origins = "http://localhost:3000")
    @DeleteMapping("/delete/{logId}")
    public ResponseEntity<HttpStatus> deleteLogin(@PathVariable("logId") Long logId) {
        try {
            loginService.deleteLogin(logId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
