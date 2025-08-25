package com.university.university_management_system.model;

import jakarta.persistence.*;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private int credits;

    private String description;

    public Course() {
    }

    public Course(Long id, String title, int credits, String description) {
        this.id = id;
        this.title = title;
        this.credits = credits;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString(){
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", credits='" + credits + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
