package com.geekyants.auth2.entities;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@DynamicInsert(true)
@DynamicUpdate(true)
@Table(name="details")
public @Data class Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Long id;
    @Column(unique = true)
    private String phoneNumber;
    @Column
    private String gender;
}
