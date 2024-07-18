package com.project.registrationonline.model;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "form")
public class RegistrationForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FormID")
    private Long formId;

    @Column(name = "NGOName", nullable = false)
    private String ngoName;

    @Column(name = "TotalNumberOfNGOMembers", nullable = false)
    private int totalNumberOfNGOMembers;

    @Column(name = "Email", nullable = false)
    private String email;

    @Column(name = "TypeOfServicesProvided", nullable = false)
    private String typeOfServicesProvided;

    @Column(name = "RegistrationDate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date registrationDate;

    @Column(name = "StartingCapital", nullable = false)
    private double startingCapital;

    // Getters and Setters

    public Long getFormId() {
        return formId;
    }

    public void setFormId(Long formId) {
        this.formId = formId;
    }

    public String getNgoName() {
        return ngoName;
    }

    public void setNgoName(String ngoName) {
        this.ngoName = ngoName;
    }

    public int getTotalNumberOfNGOMembers() {
        return totalNumberOfNGOMembers;
    }

    public void setTotalNumberOfNGOMembers(int totalNumberOfNGOMembers) {
        this.totalNumberOfNGOMembers = totalNumberOfNGOMembers;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTypeOfServicesProvided() {
        return typeOfServicesProvided;
    }

    public void setTypeOfServicesProvided(String typeOfServicesProvided) {
        this.typeOfServicesProvided = typeOfServicesProvided;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public double getStartingCapital() {
        return startingCapital;
    }

    public void setStartingCapital(double startingCapital) {
        this.startingCapital = startingCapital;
    }
}
