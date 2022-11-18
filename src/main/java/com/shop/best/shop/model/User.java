package com.shop.best.shop.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "users")
@JsonRootName(value = "user")
@JsonPropertyOrder({"lastName", "id", "firstName", "gender", "registrationDate", "street", "town"})
public class User {
    @Id
    /*
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //@Column(nullable = false, unique = true)
    @Column(unique = true)
    private String firstName;
    private String lastName;
    private String password;
    @Transient
    //@JsonIgnore
    private boolean gender;
    @Transient
    private String town;
    private String street;
    private LocalDate registrationDate;

    public User(Integer id, String firstName, String lastName, String password, boolean gender, String town, String street, LocalDate registrationDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.gender = gender;
        this.town = town;
        this.street = street;
        this.registrationDate = registrationDate;
    }

    public User(String firstName, String lastName, String password, boolean gender, String town, String street) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.gender = gender;
        this.town = town;
        this.street = street;
        this.registrationDate = LocalDate.now();
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", town='" + town + '\'' +
                ", street='" + street + '\'' +
                ", registrationDate=" + registrationDate +
                '}';
    }
}
