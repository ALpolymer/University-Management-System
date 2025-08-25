package com.university.university_management_system.model;

import jakarta.persistence.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name= "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private int code;


    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    private Set<Professor> professors = new HashSet<>();

    public Department() {
    }


    public Department(Long dep_id, String name, int code) {
        this.id = dep_id;
        this.name = name;
        this.code = code;
    }


    public Long getDep_id() {
        return id;
    }

    public void setDep_id(Long id) {
        id = this.id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Set<Professor> getAllProfessors(){
        return Collections.unmodifiableSet(professors);
    }

    public Set<Professor> getProfessors() {
        return professors;
    }

    public void setProfessors(Set<Professor> professors) {
        this.professors = professors;
    }

    public void addProfessor(Professor professor){
        if(professors == null) professors = new HashSet<>();
        professors.add(professor);
        professor.setDepartment(this);
    }

    public void removeProfessor(Professor professor){
        professors.remove(professor);
        professor.setDepartment(null);
    }





    @Override
    public String toString(){
        return "Department{" +
                "id=" + id+
                ", title='" + name + '\'' +
                ", credits='" + code + '\'' +
                '}';
    }
}
