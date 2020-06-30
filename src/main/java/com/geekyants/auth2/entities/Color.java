package com.geekyants.auth2.entities;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;

@Entity
@DynamicInsert
@DynamicUpdate
@Table
public @Data class Color extends RepresentationModel<Color> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    Long id;

    private String hex;
    private String rgb;
}
