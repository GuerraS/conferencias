package com.conferencia.sesiones.utils;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component
public class DateUtil {
	
	public LocalDateTime getCurrentLocalDAteTime() {
		return  LocalDateTime.now();
	}
	
}
