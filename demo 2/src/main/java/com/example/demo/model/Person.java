package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.sql.Timestamp;

@Entity
@Table(name = "Person")
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Имя не должно быть пустым")
    @Size(min = 2, max = 100, message = "Имя больше 2 символов и меньше 100")
    @Column(name = "username")
    private String username;

    @NotEmpty(message = "Пароль не должен быть пустым")
    @Size(min = 6)
    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @Column(name = "birthday")
    private String birthday;

    @Column(name = "gender")
    private String gender;

    @Column(name = "registration_date")
    private Timestamp registration_time;

    public Person(){}

    public Person(String username, String birthday) {
        this.username = username;
        this.birthday = birthday;
    }

    public Person(String username, String password, String birthday, String role, String gender) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.birthday = birthday;
        this.gender = gender;
    }

    public Timestamp getRegistration_time() {
        return registration_time;
    }

    public void setRegistration_time(Timestamp registration_time) {
        this.registration_time = registration_time;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", yearBirth=" + birthday +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
