package com.example.demo.model;
import java.time.LocalDateTime;

import jakarta.persistence.*;


@Entity
@Table(name="tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name="description", nullable = false)
    private String description;

    @Column (name="status", nullable = false)
    private String status;

    @Column (name="createdat", nullable = false)
    private LocalDateTime createdAt;

    @Column (name="updatedat", nullable = false)
    private LocalDateTime updatedAt;

    @Override
    public String toString(){
        return String.format("Task{id=%d, description='%s', status='%s', createdAt=%s, updatedAt=%s}", this.getId(), this.getDescription(), this.getStatus(), this.getCreatedAt(), this.getUpdatedAt());
    }
    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
