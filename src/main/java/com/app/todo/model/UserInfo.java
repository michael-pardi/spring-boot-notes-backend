package com.app.todo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
@Getter
@Setter
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", length = 25)
    private Integer id;

    @Column(name = "username", length = 50)
    private String userName;

    @Column(name = "password", length = 800)
    private String password;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "role", length = 50)
    private String role;

    @Column(name = "enabled")
    private short enabled;

    @Override
    public String toString() {
        return String.format("UserInfo [id=%s, userName=%s, password=%s, email=%s, role=%s, enabled=%s]", id, userName, password, email,
                role, enabled);
    }

}