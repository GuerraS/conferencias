package com.conferencia.sesiones.entity;

import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "user", schema = "conferencias", catalog = "")
public class User {
	
    @Id
	@Column(name = "id_person", nullable = false)
    private int idPerson;
	  
    @Column(name = "id_user", nullable = false)
    private int idUser;
    
    @Basic
    @Column(name = "username", nullable = false, length = 45)
    private String username;
    
    @Basic
    @Column(name = "password", nullable = false, length = 45)
    private String password;
    
    @Basic
    @Column(name = "updated", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime updated;
    
    @Basic
    @Column(name = "created", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime created;
    
    @Basic
    @Column(name = "status", nullable = false, length = 1)
    private char status;
     
    @PrePersist
    public void prePersist() {
        this.updated =  LocalDateTime.now() ;
    }

}
