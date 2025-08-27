package com.university.university_management_system.model;

import jakarta.persistence.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
    private Set<Enrollment> enrollments = new HashSet<>();

    public Course() {
    }

    public Course(Long id, String title, int credits, String description, Professor professor) {
        this.id = id;
        this.title = title;
        this.credits = credits;
        this.description = description;
        this.professor = professor;
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

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    protected Set<Enrollment> getEnrollments() {
        return enrollments;
    }

    public Set<Enrollment> getAllEnrollments() {
        return Collections.unmodifiableSet(enrollments);
    }

    public void setEnrollments(Set<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }

    public void addEnrollment(Enrollment enrollment){
        if (enrollments==null) enrollments = new HashSet<>();
        enrollments.add(enrollment);
        enrollment.setCourse(this);
    }

    public void removeEnrollment(Enrollment enrollment) {
        enrollments.remove(enrollment);
        enrollment.setCourse(null);
    }

    @Override
    public String toString(){
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", credits='" + credits + '\'' +
                ", description='" + description + '\'' +
                ", professor='" + professor + '\'' +
                '}';
    }
}
