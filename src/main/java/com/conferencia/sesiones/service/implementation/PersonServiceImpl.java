package com.conferencia.sesiones.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conferencia.sesiones.entity.Person;
import com.conferencia.sesiones.repository.PersonRepository;
import com.conferencia.sesiones.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService{
	@Autowired
	private PersonRepository personRepository;
	
	@Override
	public Person getPerson(int id) {
		return personRepository.findById(id).orElse(null);
	}

}
