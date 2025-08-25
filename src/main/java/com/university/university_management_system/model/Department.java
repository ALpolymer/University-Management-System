package com.university.university_management_system.model;

import jakarta.persistence.*;

@Entity
@Table
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
