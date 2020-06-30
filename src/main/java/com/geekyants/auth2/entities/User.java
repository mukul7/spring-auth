package com.geekyants.auth2.entities;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;

@Entity
@DynamicInsert(true)
@DynamicUpdate(true)
@Table(name="users")
public @Data class User extends RepresentationModel<User> {


    public enum Role {
        user,
        admin,
        customer
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Long id;

    @Column(unique = true)
    private String username;
    @Column
    private String password;

    @Column(columnDefinition = "ENUM('user', 'admin', 'customer')")
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    @RestResource(path = "details", rel="details")
    private Detail detail;
}

