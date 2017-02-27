package com.capstone_project.models;

import javax.persistence.*;

/**
 * Created by nedwaldie on 2/27/17.
 */
@Entity
@Table(name = "calendar")
public class Calendar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 30)
    private String title;

    @Column(nullable = false)
    private String date;

    @Column(nullable = false, length = 500)
    private String description;

    public Calendar(Calendar calendar) {
        title = calendar.title;
        date = calendar.date;
        description = calendar.description;
    }

    public Calendar(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
