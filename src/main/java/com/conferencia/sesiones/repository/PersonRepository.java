package com.conferencia.sesiones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.conferencia.sesiones.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>{

}
