package com.university.university_management_system.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private String firstname;

    @Column (nullable = false)
    private String lastname;

    @Column (nullable = false)
    private LocalDate enrollmentDate;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private Set<Enrollment> enrollments = new HashSet<>();


    public Student() {
    }

    public Student(Long id, String firstname, String lastname, LocalDate enrollmentDate) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.enrollmentDate = enrollmentDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
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
        if(enrollments == null) enrollments = new HashSet<>();
        enrollments.add(enrollment);
        enrollment.setStudent(this);
    }

    public void removeEnrollment(Enrollment enrollment){
        enrollments.remove(enrollment);
        enrollment.setStudent(null);
    }

    @Override
    public String toString(){
        return "Student{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", enrollmentDate='" + enrollmentDate + '\'' +
                '}';
    }
}
