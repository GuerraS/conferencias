package com.conferencia.sesiones.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conferencia.sesiones.entity.Guest;
import com.conferencia.sesiones.repository.GuestRepository;
import com.conferencia.sesiones.service.GuestService;

@Service
public class GuestServiceImpl implements GuestService{

	@Autowired
	private GuestRepository guestRepository;
	
	@Override
	public List<Guest> listAllGuest() {
		List<Guest> listMeet = guestRepository.findAll();
		return listMeet;
	}

	@Override
	public Guest getGuest(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Guest createGuest(Guest guest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Guest updateGuest(Guest guest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Guest deleteGuest(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
