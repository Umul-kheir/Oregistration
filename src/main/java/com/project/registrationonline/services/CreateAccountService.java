package com.project.registrationonline.services;

import com.project.registrationonline.model.CreateAccount;
import com.project.registrationonline.repository.CreateAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreateAccountService {
    @Autowired
    private final CreateAccountRepository createAccountRepository;

    
    public CreateAccountService(CreateAccountRepository createAccountRepository) {
        this.createAccountRepository = createAccountRepository;
    }

    public List<CreateAccount> getAllAccounts() {
        return createAccountRepository.findAll();
    }

    public Optional<CreateAccount> getAccountById(Long id) {
        return createAccountRepository.findById(id);
    }

    public CreateAccount createAccount(CreateAccount account) {
        return createAccountRepository.save(account);
    }

    public CreateAccount updateAccount(Long id, CreateAccount accountDetails) {
        Optional<CreateAccount> accountData = createAccountRepository.findById(id);
        if (accountData.isPresent()) {
            CreateAccount updatedAccount = accountData.get();
            updatedAccount.setNgoName(accountDetails.getNgoName());
            updatedAccount.setPassword(accountDetails.getPassword());
            return createAccountRepository.save(updatedAccount);
        }
        return null;
    }

    public void deleteAccount(Long id) {
        createAccountRepository.deleteById(id);
    }
}
