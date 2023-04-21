package com.example.ktra2.model;

import java.io.Serializable;

public class Item implements Serializable {
    private int id;
    private String title, description,date,status;
    private Boolean team;

    public Item(int id, String title, String description, String date, String status, Boolean team) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = date;
        this.status = status;
        this.team = team;
    }

    public Item(String title, String description, String date, String status, Boolean team) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.status = status;
        this.team = team;
    }

    public Item() {
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getTeam() {
        return team;
    }

    public void setTeam(Boolean team) {
        this.team = team;
    }
}
