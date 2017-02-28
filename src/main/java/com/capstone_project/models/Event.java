package com.capstone_project.models;

import javax.persistence.*;

/**
 * Created by Harry on 2/24/17.
 */
@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    private String eventName;

    @Column(nullable = false, length = 100)
    private String location;

    @Column(nullable = false)
    private String startDate;

    @Column(nullable = false)
    private String endDate;

    @Column(nullable = true, length = 100)
    private String eventWeb;

    @Column(nullable = true, length = 10)
    private String eventPhone;

    @Column(nullable = true, length = 100)
    private String eventPoc;

    @Column(nullable = true, length = 10)
    private String eventPocPhone;

    @Column(nullable = false, length = 2000)
    private String description;

    public Event(String eventName, String location, String startDate, String endDate, String eventWeb, String eventPhone, String eventPoc, String eventPocPhone, String description) {
        this.eventName = eventName;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
        this.eventWeb = eventWeb;
        this.eventPhone = eventPhone;
        this.eventPoc = eventPoc;
        this.eventPocPhone = eventPocPhone;
        this.description = description;
    }

    public Event(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getEventWeb() {
        return eventWeb;
    }

    public void setEventWeb(String eventWeb) {
        this.eventWeb = eventWeb;
    }

    public String getEventPhone() {
        return eventPhone;
    }

    public void setEventPhone(String eventPhone) {
        this.eventPhone = eventPhone;
    }

    public String getEventPoc() {
        return eventPoc;
    }

    public void setEventPoc(String eventPoc) {
        this.eventPoc = eventPoc;
    }

    public String getEventPocPhone() {
        return eventPocPhone;
    }

    public void setEventPocPhone(String eventPocPhone) {
        this.eventPocPhone = eventPocPhone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}