package com.capstone_project.models;

import javax.persistence.*;

/**
 * Created by nedwaldie on 2/16/17.
 */
@Entity
@Table(name = "merchants")
public class Merchants {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 45)
    private double lat;

    @Column(nullable = false, length = 45)
    private double lon;

    @Column(nullable = false, length = 45)
    private String busName;

    @Column(nullable = false, length = 45)
    private String phone;

    @Column(nullable = false, length = 5000)
    private String description;

    @Column(nullable = false)
    private boolean approved;

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
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
