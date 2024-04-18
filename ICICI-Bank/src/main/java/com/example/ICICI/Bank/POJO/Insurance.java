package com.example.ICICI.Bank.POJO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int insuranceid;
    private String type;
    private double insuranceamt;

    public int getInsuranceid() {
        return insuranceid;
    }

    public void setInsuranceid(int insuranceid) {
        this.insuranceid = insuranceid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getInsuranceamt() {
        return insuranceamt;
    }

    public void setInsuranceamt(double insuranceamt) {
        this.insuranceamt = insuranceamt;
    }
}
