package com.conferencia.sesiones.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conferencia.sesiones.entity.Meet;
import com.conferencia.sesiones.entity.User;
import com.conferencia.sesiones.repository.MeetRepository;
import com.conferencia.sesiones.repository.UserRepository;
import com.conferencia.sesiones.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;

	@Override
	public User getUser(int id) {
		return userRepository.findById(id).orElse(null);
	}
}
