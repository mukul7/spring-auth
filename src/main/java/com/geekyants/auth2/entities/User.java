package com.geekyants.auth2.entities;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name="users")
@DynamicInsert(true)
@DynamicUpdate(true)
public class User {

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Long id;

    @Column
    private String userName;

    @Column
    private String password;
}
