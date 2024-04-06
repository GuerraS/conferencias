package com.conferencia.sesiones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.conferencia.sesiones.entity.Meet;
import com.conferencia.sesiones.entity.Person;
import com.conferencia.sesiones.entity.User;

@Repository
public interface MeetRepository extends JpaRepository<Meet, Integer>{
	public List<Meet> findByPerson(Person person);
}
