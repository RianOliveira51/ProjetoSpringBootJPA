package com.example.portaChamados.entities;

import com.example.portaChamados.entities.enums.CalledStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Called")
public class Called {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private CalledStatus status;
    private String text;
    private String comment;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user.id")
    private User user;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "technician.id")
    private Technicians technicians;

    public Called(){

    }

    public Called(Integer id, CalledStatus status, String text, User user , String comment) {
        Id = id;
        this.status = status;
        this.text = text;
        this.user = user;
        this.comment = comment;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public CalledStatus getStatus() {
        return status;
    }

    public void setStatus(CalledStatus status) {
        this.status = status;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Technicians getTechnicians() {
        return technicians;
    }

    public void setTechnicians(Technicians technicians) {
        this.technicians = technicians;
    }

    public String getComment(){
        return comment;
    }

    public void setComment(String comment){
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Called called = (Called) o;
        return Objects.equals(Id, called.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(Id);
    }

    @Override
    public String toString() {
        return "Called{" +
                "Id=" + Id +
                ", status=" + status +
                ", text='" + text + '\'' +
                ", user=" + user +
                ", technicians=" + technicians +
                ", comment='" + comment + '\'' +
                '}';
    }
}
