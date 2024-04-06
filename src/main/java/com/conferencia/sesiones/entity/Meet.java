package com.conferencia.sesiones.entity;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor @NoArgsConstructor @Builder
@Data
@Table(name = "meet", schema = "conferencias", catalog = "")
public class Meet {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_meet", nullable = false)
    private int idMeet;

    @Column(name = "schedule_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date scheduleDate;

    @Column(name = "schedule_time", nullable = false)
    @Temporal(TemporalType.TIME)
    private Time scheduleTime;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "description", nullable = false, length = 250)
    private String description;

    @Column(name = "updated", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime updated;
    
    @Column(name = "created", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime created;

    @Basic
    @Column(name = "status", nullable = false, length = 1)
    private char status;
    
    //relations
    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @NotNull(message = "La conferencia debe pertenecer a un usuario")
    @JoinColumn(name="id_owner_person", nullable=false)
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Person person;

//    @OneToMany(fetch = FetchType.EAGER, mappedBy="meet")
//    private Set<Guest> guest;

}
