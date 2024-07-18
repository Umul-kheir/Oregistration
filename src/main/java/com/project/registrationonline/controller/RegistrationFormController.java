package com.project.registrationonline.controller;

import com.project.registrationonline.model.RegistrationForm;
import com.project.registrationonline.repository.RegistrationFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin (origins = "http://localhost:3000")
@RequestMapping("/api/forms")
public class RegistrationFormController {
    @Autowired
    private final RegistrationFormRepository registrationFormRepository;

    
    public RegistrationFormController(RegistrationFormRepository registrationFormRepository) {
        this.registrationFormRepository = registrationFormRepository;
    }

    // Create
    @CrossOrigin (origins = "http://localhost:3000")
    @PostMapping("/add")
    public ResponseEntity<RegistrationForm> addRegistrationForm(@RequestBody RegistrationForm registrationForm) {
        try {
            RegistrationForm newForm = registrationFormRepository.save(registrationForm);
            return new ResponseEntity<>(newForm, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Read all forms
    @CrossOrigin (origins = "http://localhost:3000")
    @GetMapping("/all")
    public ResponseEntity<List<RegistrationForm>> getAllRegistrationForms() {
        List<RegistrationForm> forms = registrationFormRepository.findAll();
        if (forms.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(forms, HttpStatus.OK);
    }

    // Read one form by ID
    @CrossOrigin (origins = "http://localhost:3000")
    @GetMapping("/{formId}")
    public ResponseEntity<RegistrationForm> getRegistrationFormById(@PathVariable("formId") Long formId) {
        Optional<RegistrationForm> registrationForm = registrationFormRepository.findById(formId);
        return registrationForm.map(form -> new ResponseEntity<>(form, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update
    @CrossOrigin (origins = "http://localhost:3000")
    @PutMapping("/update/{formId}")
    public ResponseEntity<RegistrationForm> updateRegistrationForm(@PathVariable("formId") Long formId,@RequestBody RegistrationForm formDetails) {
                                                                  
        Optional<RegistrationForm> formData = registrationFormRepository.findById(formId);
        if (formData.isPresent()) {
            RegistrationForm updatedForm = formData.get();
            updatedForm.setNgoName(formDetails.getNgoName());
            updatedForm.setTotalNumberOfNGOMembers(formDetails.getTotalNumberOfNGOMembers());
            updatedForm.setEmail(formDetails.getEmail());
            updatedForm.setTypeOfServicesProvided(formDetails.getTypeOfServicesProvided());
            updatedForm.setRegistrationDate(formDetails.getRegistrationDate());
            updatedForm.setStartingCapital(formDetails.getStartingCapital());

            return new ResponseEntity<>(registrationFormRepository.save(updatedForm), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete
    @CrossOrigin (origins = "http://localhost:3000")
    @DeleteMapping("/delete/{formId}")
    public ResponseEntity<HttpStatus> deleteRegistrationForm(@PathVariable("formId") Long formId) {
        try {
            registrationFormRepository.deleteById(formId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
