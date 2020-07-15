package com.geekyants.auth2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;

@Entity
@DynamicInsert
@DynamicUpdate
@Table
public @Data class Detail extends RepresentationModel<Detail> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Long id;
    @Column(unique = true)
    private String phoneNumber;
    @Column
    private String gender;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    @RestResource(path = "homeAddress", rel="homeAddress")
    private Address homeAddress;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    @RestResource(path = "officeAddress", rel="officeAddress")
    private Address officeAddress;
}
