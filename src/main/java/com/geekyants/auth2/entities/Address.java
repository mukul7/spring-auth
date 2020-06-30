package com.geekyants.auth2.entities;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name="addresses")
@DynamicInsert(true)
@DynamicUpdate(true)
public @Data class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Long id;
    @Column
    Long userId;
    @Column
    String address;

}
