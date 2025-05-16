package com.dauphine.blogger_box_backend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime createdDate;
    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;
public Post(){}
    public Post(UUID id, String title, String content, LocalDateTime createdDate, Category category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
        this.category = category;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
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

    public LocalDateTime getDate() {
        return createdDate;
    }

    public void setDate(LocalDateTime date) {
        this.createdDate = date;
    }

    public Category getCategory() {
        return category;
    }

    public void setCreatedDate(LocalDateTime createddate) {
        this.createdDate = createddate;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

