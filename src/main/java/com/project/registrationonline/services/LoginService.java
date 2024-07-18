package com.project.registrationonline.services;

import com.project.registrationonline.model.Login;
import com.project.registrationonline.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginService {
    @Autowired
    private final LoginRepository loginRepository;

    
    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public Login saveLogin(Login login) {
        return loginRepository.save(login);
    }

    public List<Login> getAllLogins() {
        return loginRepository.findAll();
    }

    public Optional<Login> getLoginById(Long id) {
        return loginRepository.findById(id);
    }

    public Login updateLogin(Long id, Login loginDetails) {
        Optional<Login> loginData = loginRepository.findById(id);
        if (loginData.isPresent()) {
            Login updatedLogin = loginData.get();
            updatedLogin.setUsername(loginDetails.getUsername());
            updatedLogin.setPassword(loginDetails.getPassword());

            return loginRepository.save(updatedLogin);
        } else {
            return null;
        }
    }

    public void deleteLogin(Long id) {
        loginRepository.deleteById(id);
    }
}
