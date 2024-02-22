package com.snmhecom.entities;
import jakarta.persistence.*;

import java.io.Serializable;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
@Entity
public class User implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long user_id;

    @Column(unique = true)
    private String email;

    private String password;
    private String role="user";
    private Long mobile;
    private String first_name;
    private String family_name;

    public User() {
        super();
    }

    public User(String email, String password, String role, Long mobile, String first_name, String family_name) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.mobile = mobile;
        this.first_name = first_name;
        this.family_name = family_name;
    }

    public User(String email, String password, Long mobile, String first_name, String family_name) {
        this.email = email;
        this.password = password;
        this.mobile = mobile;
        this.first_name = first_name;
        this.family_name = family_name;
    }

    public Long getUser_id() {
        return user_id;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getFamily_name() {
        return family_name;
    }

    public void setFamily_name(String family_name) {
        this.family_name = family_name;
    }
}
