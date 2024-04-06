package com.conferencia.sesiones.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.conferencia.sesiones.DTO.MeetDTO;
import com.conferencia.sesiones.entity.Meet;
import com.conferencia.sesiones.entity.Person;
import com.conferencia.sesiones.service.MeetService;
import com.conferencia.sesiones.service.PersonService;
import com.conferencia.sesiones.utils.ErrorMessage;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Tag(name="Meet Controller", description="Controlador para crud de conferencias")
@Slf4j
@RestController
@RequestMapping(value = "/conferencias")
public class MeetController {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private MeetService meetService;
	
	@Autowired
	private PersonService personService;
	
	
	@GetMapping
	public ResponseEntity<List<Meet>> ListMeets(@RequestParam(name="personId", required = false) Integer personId){
		List<Meet> listMeets = new ArrayList<Meet>();
		if(personId == null) {		
			listMeets = meetService.listAllMeets();
			if (listMeets.isEmpty())
				return ResponseEntity.noContent().build();
		}else {
			listMeets = meetService.findByPerson(Person.builder().idPerson(personId).build());
			if (listMeets.isEmpty())
				return ResponseEntity.notFound().build();
		}
		
			
		return ResponseEntity.ok(listMeets);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Meet> getMeet(@PathVariable(value = "id") int id){
		Meet meet = meetService.getMeet(id);
		if (null == meet)
			return ResponseEntity.noContent().build();	
		return ResponseEntity.ok(meet);
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<MeetDTO> createMeet(@Valid @RequestBody MeetDTO meetDto, BindingResult result) {
		if(result.hasErrors()) {
			ErrorMessage errorMessage = new ErrorMessage();
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errorMessage.formatMessaage(result) );
		}
		
		
		Meet meet = modelMapper.map(meetDto, Meet.class);
		Person person = personService.getPerson(meetDto.getIdOwnerPerson());
		meet.setPerson(person);
		meet.setIdMeet(0);
		meet.setStatus('1');
		meet.setCreated(LocalDateTime.now());
		meet.setUpdated(LocalDateTime.now());	
		Meet meetCreate = meetService.createMeet(meet);
		if(null == meetCreate) {
			log.error("Unable to update. Meet with id {} not found.", meet.getIdMeet());
			return ResponseEntity.internalServerError().build();	
		}
		
		MeetDTO postResponse = modelMapper.map(meet, MeetDTO.class);
		postResponse.setIdOwnerPerson(person.getIdPerson());
		return ResponseEntity.status(HttpStatus.CREATED).body(postResponse);
	};
//	
	@PutMapping(value="/{id}")
	public ResponseEntity<MeetDTO> updateMeet(@PathVariable("id") int idMeet, @Valid @RequestBody MeetDTO meetDto, BindingResult result) {
		
		if (result.hasErrors()) {
			ErrorMessage errorMessage = new ErrorMessage();
			String error = errorMessage.formatMessaage(result);
			log.error("Json with errors", error);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, error);
		}
		
		meetDto.setIdMeet(idMeet);
		Meet meet = modelMapper.map(meetDto, Meet.class);
		Person person = personService.getPerson(meetDto.getIdOwnerPerson());
		meet.setPerson(person);
		Meet currentMeet = meetService.updateMeet(meet);

		if (currentMeet == null) {
			log.error("Unable to update. Meet with id {} not found.", meet.getIdMeet());
			return ResponseEntity.notFound().build();
		}
		
		MeetDTO postResponse = modelMapper.map(currentMeet, MeetDTO.class);
		postResponse.setIdOwnerPerson(person.getIdPerson());
		return ResponseEntity.ok(postResponse);
	};

}
