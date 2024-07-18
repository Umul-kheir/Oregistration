package com.project.registrationonline.services;

import com.project.registrationonline.model.RegistrationForm;
import com.project.registrationonline.repository.RegistrationFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistrationFormServices {
    @Autowired
    private final RegistrationFormRepository registrationFormRepository;

    
    public RegistrationFormServices(RegistrationFormRepository registrationFormRepository) {
        this.registrationFormRepository = registrationFormRepository;
    }

    public RegistrationForm saveForm(RegistrationForm form) {
        return registrationFormRepository.save(form);
    }

    public List<RegistrationForm> getAllForms() {
        return registrationFormRepository.findAll();
    }

    public Optional<RegistrationForm> getFormById(Long id) {
        return registrationFormRepository.findById(id);
    }

    public RegistrationForm updateForm(Long id, RegistrationForm formDetails) {
        Optional<RegistrationForm> formData = registrationFormRepository.findById(id);
        if (formData.isPresent()) {
            RegistrationForm updatedForm = formData.get();
            updatedForm.setNgoName(formDetails.getNgoName());
            updatedForm.setTotalNumberOfNGOMembers(formDetails.getTotalNumberOfNGOMembers());
            updatedForm.setEmail(formDetails.getEmail());
            updatedForm.setTypeOfServicesProvided(formDetails.getTypeOfServicesProvided());
            updatedForm.setRegistrationDate(formDetails.getRegistrationDate());
            updatedForm.setStartingCapital(formDetails.getStartingCapital());

            return registrationFormRepository.save(updatedForm);
        } else {
            return null;
        }
    }

    public void deleteForm(Long id) {
        registrationFormRepository.deleteById(id);
    }
}
