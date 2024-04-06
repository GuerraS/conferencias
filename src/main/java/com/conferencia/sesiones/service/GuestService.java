package com.conferencia.sesiones.service;

import java.util.List;

import com.conferencia.sesiones.entity.Guest;

public interface GuestService {
	public List<Guest> listAllGuest();
	public Guest getGuest(Long id);
	public Guest createGuest(Guest guest);
	public Guest updateGuest(Guest guest);
	public Guest deleteGuest(Long id);
}
