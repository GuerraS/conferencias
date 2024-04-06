package com.conferencia.sesiones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.conferencia.sesiones.entity.Guest;

@Repository
public interface GuestRepository  extends JpaRepository<Guest, Integer>{

}
