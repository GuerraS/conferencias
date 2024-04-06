package com.conferencia.sesiones.entity;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(name="Person", description="Entidad para mapear registros de la tabla person")
@Entity
@Data
@Builder
@AllArgsConstructor @NoArgsConstructor
@Table(name = "person", schema = "conferencias", catalog = "")
public class Person {
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Id
	@Column(name = "id_person", nullable = false)
	private int idPerson;

	@Column(name = "name", nullable = false, length = 45)
	private String name;

	@Column(name = "first_name", nullable = false, length = 45)
	private String firstName;

	@Column(name = "last_name", nullable = false, length = 45)
	private String lastName;

	@Column(name = "email", nullable = false, length = 45)
	private String email;

	@Column(name = "updated", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime updated;

	@Column(name = "created", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime created;

	@Column(name = "status", nullable = false, length = 1)
	private char status;

	// Relations
	@OneToOne( fetch = FetchType.LAZY)
	@JoinColumn(name = "id_person", referencedColumnName = "idPerson")
	private User userEntity;

//	@OneToMany(mappedBy = "person",  fetch = FetchType.LAZY)
//	private List<Guest> guestEntity;

//	@OneToMany(mappedBy = "person", fetch = FetchType.LAZY)
//	private Set<Meet> meetEntity;

}
