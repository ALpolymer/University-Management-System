package com.university.university_management_system.model;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name="enrollments")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int grade;

    @Column(nullable = false)
    private LocalDate enrollmentDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;



    public Enrollment() {
    }

    public Enrollment(Long id, int grade, LocalDate enrollmentDate, Student student, Course course) {
        this.id = id;
        this.grade = grade;
        this.enrollmentDate = enrollmentDate;
        this.student = student;
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString(){
        return "Enrollment{" +
                "id=" + id +
                ", grade='" + grade + '\'' +
                ", enrollmentDate='" + enrollmentDate + '\'' +
                '}';
    }
}
