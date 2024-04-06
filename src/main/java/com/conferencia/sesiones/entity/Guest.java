package com.conferencia.sesiones.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "guest", schema = "conferencias", catalog = "")
public class Guest  {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_guest", nullable = false)
    private int idGuest;

    @Basic
    @Column(name = "status", nullable = false, length = 1)
    private char status;
    
    
    //relation
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_person", nullable=false)
    private Person person;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_meet", nullable=false)
    private Meet meet;

}
