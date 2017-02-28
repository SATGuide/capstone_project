package com.capstone_project.models;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.List;

/**
 * Created by nedwaldie on 2/16/17.
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username")
    @NotBlank(message = "Enter a username: ")
    private String username;

    @Column(nullable = false, length = 45)
    @NotBlank(message = "Enter a valid email address: ")
    private String email;

    @Column(nullable = false)
    @NotBlank(message = "Enter a strong password, using upper and lower case letters and numbers: ")
    private String password;

    @Column(nullable = false, length = 30)
    @NotBlank(message = "Enter your first name: ")
    private String firstName;

    @Column(nullable = false, length = 30)
    @NotBlank(message = "Enter your last name: ")
    private String lastName;

    @Column(nullable = false, length = 45)
    @NotBlank(message = "Enter your company/business name: ")
    private String company;

    @Column(nullable = false, length = 10)
    @NotBlank(message = "Enter your 10-digit phone number, using numbers only: ")
    private String phone;


    public User(User user) {
        id = user.id;
        email = user.email;
        password = user.password;
        firstName = user.firstName;
        lastName = user.lastName;
        company = user.company;
        phone = user.phone;
    }

    public User() {}

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
