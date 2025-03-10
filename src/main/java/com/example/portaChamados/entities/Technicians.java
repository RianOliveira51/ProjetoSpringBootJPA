package com.example.portaChamados.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "Technicians")
public class Technicians implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String login;
    private String password;

    @OneToMany(mappedBy = "technicians")
    private Set<Called> technicians = new HashSet<>();

    public Technicians(){

    }

    public Technicians(Integer id, String name, String login, String password) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String username) {
        this.login = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Called> getTechnicians() {
        return technicians;
    }

    public void setTechnicians(Set<Called> technicians) {
        this.technicians = technicians;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "HelpDesk{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
