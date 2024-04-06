package com.conferencia.sesiones.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.conferencia.sesiones.entity.Guest;
import com.conferencia.sesiones.service.GuestService;

@RestController
@RequestMapping(value = "/invitados")
public class GuestController {
	
	@Autowired
	private GuestService guestService;
	
	@GetMapping
	public ResponseEntity<List<Guest>> ListProducts(@RequestParam(name="categoryId", required = false) Long categoryId){
		List<Guest> listGuest = new ArrayList<Guest>();
		
		listGuest = guestService.listAllGuest();
			if (listGuest.isEmpty())
				return ResponseEntity.noContent().build();
			
		return ResponseEntity.ok(listGuest);
	}
}
