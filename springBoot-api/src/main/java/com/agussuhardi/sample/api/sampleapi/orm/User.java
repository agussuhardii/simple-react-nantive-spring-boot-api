package com.agussuhardi.sample.api.sampleapi.orm;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * DAO (Data Access Object)
 */
@Entity
@Table(name = "user_account")
@Data
public class User {

    public static final int STATUS_ACTIVE = 10;

    public static final int STATUS_DELETED = 0;

    public static final int STATUS_APPROVED = 2;

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(name = "username")
    private String username;

    @Column(name = "auth_key")
    private String authKey;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @JsonIgnore
    @Column(name = "password")
    private String password;

    @Column(name = "status")
    private int status;

    @CreationTimestamp
    @Column(nullable = false, updatable = false, name = "created_at")
    private Timestamp createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private Timestamp updatedAt;

    @Column(name = "phone")
    private String phoneNumber;

}
