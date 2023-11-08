package com.web.usersmanagement.model;

import com.web.usersmanagement.enumes.TypeRole;
import com.web.usersmanagement.enumes.TypeSubject;
import jakarta.persistence.*;
import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="users")
        public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    //private String nickname;
    @Enumerated(EnumType.STRING)
    private TypeRole typeRole;
    @Column(name = "password")
    private String password;
    @Column(name = "surname", nullable = false)
    private String surname;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }


}