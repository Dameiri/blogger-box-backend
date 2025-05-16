package com.dauphine.blogger_box_backend.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

import java.sql.Timestamp;
import java.util.UUID;
@Entity
@Table(name ="post")
public class Post {
    @Id
    @Column(name="id")
    private UUID id;
    @Column(name="  title", nullable = false, length = 250)
    private String title;
    @Column(name="content", nullable = false, columnDefinition = "TEXT")
    private String content;
    @Column(name="created_date", nullable = false)
    private LocalDate createddate;
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    Category category;
public Post(){}
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

