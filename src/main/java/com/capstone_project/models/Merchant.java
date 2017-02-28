package com.capstone_project.models;

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

    @Column(nullable = true, length = 10)
    private String busPhone;

    @Column(nullable = true, length = 5000)
    private String description;

    @Column(nullable = true, length = 200)
    private String web;

    @Column(nullable = false)
    private boolean approved;

    @ManyToOne
    @JoinColumn (name = "user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn (name = "category_id")
    private Category category;

    @ManyToOne
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

    public double getLon() {
        return lng;
    }

    public void setLon(double lng) {
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
