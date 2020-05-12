package com.app.todo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
@Getter
@Setter
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", length = 25)
    private Integer id;

    @NotNull
    @Column(name = "USERNAME", length = 50)
    private String userName;

    @NotNull
    @Column(name = "PASSWORD", length = 800)
    private String password;

    @NotNull
    @Column(name = "EMAIL", length = 50)
    private String email;

    @NotNull
    @Column(name = "ROLE", length = 50)
    private String role;

    @NotNull
    @Column(name = "ENABLED")
    private short enabled;

    @Column(name="CREATED_ON", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(name="UPDATED_ON", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    @Override
    public String toString() {
        return String.format("UserInfo [id=%s, userName=%s, password=%s, email=%s, role=%s, enabled=%s]", id, userName, password, email,
                role, enabled);
    }

}