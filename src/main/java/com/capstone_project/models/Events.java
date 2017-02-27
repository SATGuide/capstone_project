package com.capstone_project.models;

import javax.persistence.*;

/**
 * Created by Harry on 2/24/17.
 */
@Entity
@Table(name = "events")
public class Events {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    private String event_name;

    @Column(nullable = false, length = 100)
    private String location;

    @Column(nullable = false)
    private String start_date;

    @Column(nullable = false)
    private String end_date;

    @Column(nullable = true, length = 100)
    private String event_web;

    @Column(nullable = true, length = 10)
    private String event_phone;

    @Column(nullable = true, length = 100)
    private String event_poc;

    @Column(nullable = true, length = 10)
    private String event_poc_phone;

    @Column(nullable = false, length = 2000)
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getEvent_web() {
        return event_web;
    }

    public void setEvent_web(String event_web) {
        this.event_web = event_web;
    }

    public String getEvent_phone() {
        return event_phone;
    }

    public void setEvent_phone(String event_phone) {
        this.event_phone = event_phone;
    }

    public String getEvent_poc() {
        return event_poc;
    }

    public void setEvent_poc(String event_poc) {
        this.event_poc = event_poc;
    }

    public String getEvent_poc_phone() {
        return event_poc_phone;
    }

    public void setEvent_poc_phone(String event_poc_phone) {
        this.event_poc_phone = event_poc_phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}