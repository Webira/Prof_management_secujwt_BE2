package com.web.usersmanagement.model;

import com.web.usersmanagement.enumes.TypeClient;
import com.web.usersmanagement.enumes.TypeSubject;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Entity
    @Table(name ="professors ")
    public class Professor  {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(name = "firstname", nullable = false, unique = true)
        private String firstname;
        @Column(name = "surname", nullable = false)
        private String surname;
        @Enumerated(EnumType.STRING)
        private TypeSubject typeSubject;
        @Enumerated(EnumType.STRING)
        private TypeClient typeClient;
        private String address;
        private String ville;
        @Column(name = "email", nullable = false, unique = true)
        private String email;

    }
