package com.projects.shopapp.models;

import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class BaseEntity {

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    // Tự động cập nhật createdAt và updatedAt
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDate.now();
        this.updatedAt = LocalDate.now();
    }

    // Tự động cập nhật createdAt và updatedAt
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDate.now();
    }

}
