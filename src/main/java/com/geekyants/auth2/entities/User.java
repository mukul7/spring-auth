package com.geekyants.auth2.entities;

import com.vladmihalcea.hibernate.type.basic.PostgreSQLEnumType;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;

@Entity
@DynamicInsert
@DynamicUpdate
@TypeDef(typeClass = PostgreSQLEnumType.class, name = "pgsql_enum")
@Table(name="users")
public @Data class User extends RepresentationModel<User> {


    public enum Role {
        user,
        admin,
        customer
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    Long id;

    @Column(unique = true)
    private String username;
    @Column
    private String password;

    @Enumerated(EnumType.STRING)
    @Type(type = "pgsql_enum")
    private Role role;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    @RestResource(path = "details", rel = "details")
    private Detail detail;

}

