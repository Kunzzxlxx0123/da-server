package com.spring.server.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.server.model.User;
import com.spring.server.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	
	@Autowired UserRepository userRepositoryImpl;

	@Override
	public Optional<User> findByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepositoryImpl.findByEmail(email);
	}

	@Override
	public Boolean existsByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepositoryImpl.existsByEmail(email);
	}
	
	@Override
	public Optional<User> findById(Long id) {
		// TODO Auto-generated method stub
		return userRepositoryImpl.findById(id);
	}

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return userRepositoryImpl.save(user);
	}
	
}
