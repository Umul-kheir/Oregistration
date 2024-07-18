package com.project.registrationonline.controller;

import com.project.registrationonline.model.CreateAccount;
import com.project.registrationonline.services.CreateAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin (origins = "http://localhost:3000")
@RequestMapping("/api/accounts")
public class CreateAccountController {
    @Autowired
    private final CreateAccountService createAccountService;

    
    public CreateAccountController(CreateAccountService createAccountService) {
        this.createAccountService = createAccountService;
    }

    // Create
    @CrossOrigin (origins = "http://localhost:3000")
    @PostMapping("/add")
    public ResponseEntity<CreateAccount> addAccount(@RequestBody CreateAccount createAccount) {
        try {
            CreateAccount newAccount = createAccountService.createAccount(createAccount);
            return new ResponseEntity<>(newAccount, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Read all accounts
    @CrossOrigin (origins = "http://localhost:3000")
    @GetMapping("/all")
    public ResponseEntity<List<CreateAccount>> getAllAccounts() {
        List<CreateAccount> accounts = createAccountService.getAllAccounts();
        if (accounts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    // Read one account by ID
    @CrossOrigin (origins = "http://localhost:3000")
    @GetMapping("/{id}")
    public ResponseEntity<CreateAccount> getAccountById(@PathVariable("id") Long id) {
        Optional<CreateAccount> account = createAccountService.getAccountById(id);
        return account.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update
    @CrossOrigin (origins = "http://localhost:3000")
    @PutMapping("/update/{id}")
    public ResponseEntity<CreateAccount> updateAccount(@PathVariable("id") Long id, @RequestBody CreateAccount accountDetails) {
        CreateAccount updatedAccount = createAccountService.updateAccount(id, accountDetails);
        if (updatedAccount != null) {
            return new ResponseEntity<>(updatedAccount, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete
    @CrossOrigin (origins = "http://localhost:3000")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteAccount(@PathVariable("id") Long id) {
        try {
            createAccountService.deleteAccount(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
