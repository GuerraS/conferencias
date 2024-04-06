package com.conferencia.sesiones.service.implementation;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conferencia.sesiones.entity.Meet;
import com.conferencia.sesiones.entity.Person;
import com.conferencia.sesiones.repository.MeetRepository;
import com.conferencia.sesiones.service.MeetService;

@Service
public class MeetServiceImpl implements MeetService{

	@Autowired
	private MeetRepository meetRepository;
	
	
	@Override
	public List<Meet> listAllMeets() {
		List<Meet> listMeet = meetRepository.findAll();
		return listMeet;
	}

	@Override
	public Meet getMeet(int id) {
		return meetRepository.findById(id).orElse(null);
	}

	@Override
	public Meet createMeet(Meet meet) {
		return meetRepository.save(meet);
	}

	@Override
	public Meet updateMeet(Meet meet) {
		
		Meet meetDB = getMeet(meet.getIdMeet());
        if (meetDB == null){
            return  null;
        }
        
        meetDB.setScheduleDate(meet.getScheduleDate());
        meetDB.setScheduleTime(meet.getScheduleTime());
        meetDB.setName(meet.getName());
        meetDB.setDescription(meet.getDescription());
        meetDB.setUpdated(LocalDateTime.now());
        meetDB.setStatus(meet.getStatus());
        return meetRepository.save(meetDB);
	}

	@Override
	public Meet deleteMeet(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Meet> findByPerson(Person person) {
		List<Meet> listMeet = meetRepository.findByPerson(person);

		return listMeet;
	}


}
