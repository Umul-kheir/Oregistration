package com.project.registrationonline.repository;


import com.project.registrationonline.model.RegistrationForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationFormRepository extends JpaRepository<RegistrationForm, Long> {
}

