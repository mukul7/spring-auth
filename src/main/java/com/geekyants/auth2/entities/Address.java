package com.geekyants.auth2.entities;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;

@Entity
@Table
@DynamicInsert
@DynamicUpdate
public @Data class Address extends RepresentationModel<Address> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, updatable = false)
    Long id;

    @Column
    private String country;

    @Column
    private String city;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    @RestResource(path = "color", rel="color")
    private Color color;

}
