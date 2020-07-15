package com.geekyants.auth2.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.apache.tomcat.util.buf.StringUtils;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name="users")
public @Data class User extends RepresentationModel<User> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    Long id;

    @Column(unique = true)
    private String username;

    @JsonIgnore
    @Column
    private String password;


    public ArrayList<String> getAuthorities() {
        if(authorities==null)
            return new ArrayList<>();
        return new ArrayList<>(Arrays.asList(authorities.split("\\s*,\\s*")));
    }

    public void setAuthorities(List<String> authorities) {
        this.authorities = StringUtils.join(authorities, ',');
    }

    @Column
    private String authorities;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    @RestResource(path = "details", rel = "details")
    private Detail detail;

}

