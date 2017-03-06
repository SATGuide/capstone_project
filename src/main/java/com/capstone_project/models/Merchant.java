package com.capstone_project.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

/**
 * Created by nedwaldie on 2/16/17.
 */
@Entity
@Table(name = "merchants")
public class Merchant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 45)
    private double lat;

    @Column(nullable = false, length = 45)
    private double lng;

    @Column(nullable = false, length = 100)
    private String busName;

    @Column(nullable = false, length = 100)
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Column(nullable = false, length = 30)
    private String city;

    @Column(nullable = false, length = 5)
    private String zipcode;

    @Column(nullable = true, length = 15)
    private String busPhone;

    @Column(nullable = true, length = 5000)
    private String description;

    @Column(nullable = true, length = 200)
    private String web;

    @Column(nullable = false)
    private boolean approved;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn (name = "user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JsonManagedReference
    @JoinColumn (name = "category_id")
    private Category category;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn (name = "age_check_id")
    private AgeCheck ageCheck;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public AgeCheck getAgeCheck() {
        return ageCheck;
    }

    public void setAgeCheck(AgeCheck ageCheck) {
        this.ageCheck = ageCheck;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public String getBusPhone() {
        return busPhone;
    }

    public void setBusPhone(String busPhone) {
        this.busPhone = busPhone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }
}
