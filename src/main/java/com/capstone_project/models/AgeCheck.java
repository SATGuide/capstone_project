package com.capstone_project.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Harry on 2/21/17.
 */
@Entity
@Table (name = "age_check")
public class AgeCheck {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 45)
    private String ageCheck;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ageCheck")
    @JsonBackReference
    private List<Merchant> merchants;

    public List<Merchant> getMerchants() {
        return merchants;
    }

    public void setMerchants(List<Merchant> merchants) {
        this.merchants = merchants;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAgeCheck() {
        return ageCheck;
    }

    public void setAgeCheck(String ageCheck) {
        this.ageCheck = ageCheck;
    }
}
