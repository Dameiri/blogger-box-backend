package com.dauphine.blogger_box_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.UUID;

import java.sql.Timestamp;
import java.util.UUID;

public class Post {
    private UUID id;
    private String title;
    private String content;
    private LocalDate createddate;
    private Category category;

    public Post(UUID id, String title, String content, LocalDate createdDate, Category category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createddate = createdDate;
        this.category = category;
    }

    public LocalDate getCreateddate() {
        return createddate;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getDate() {
        return createddate;
    }

    public void setDate(LocalDate date) {
        this.createddate = date;
    }

    public Category getCategory() {
        return category;
    }

    public void setCreateddate(LocalDate createddate) {
        this.createddate = createddate;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

