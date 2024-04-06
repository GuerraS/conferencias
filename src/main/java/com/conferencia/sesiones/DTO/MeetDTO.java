package com.conferencia.sesiones.DTO;

import java.sql.Time;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class MeetDTO {
	
    private int idMeet;

    private Date scheduleDate;

    private Time scheduleTime;

    private String name;

    private String description;
    
    private char status;
    
    private int idOwnerPerson;
}
