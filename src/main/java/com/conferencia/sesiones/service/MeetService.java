package com.conferencia.sesiones.service;

import java.util.List;

import com.conferencia.sesiones.entity.*;
	

public interface MeetService {
	public List<Meet> listAllMeets();
	public Meet getMeet(int id);
	public Meet createMeet(Meet meet);
	public Meet updateMeet(Meet meet);
	public Meet deleteMeet(int id);
	public List<Meet> findByPerson(Person person);


}
