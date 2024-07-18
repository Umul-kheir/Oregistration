package com.project.registrationonline.repository;

import com.project.registrationonline.model.CreateAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreateAccountRepository extends JpaRepository<CreateAccount, Long> {
}
