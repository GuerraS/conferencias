package com.conferencia.sesiones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.conferencia.sesiones.entity.Guest;
import com.conferencia.sesiones.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
}
