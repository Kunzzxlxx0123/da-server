package com.spring.server.service;

import java.util.Optional;

import com.spring.server.model.User;

public interface UserService {

	Optional<User> findByEmail(String email);

	Boolean existsByEmail(String email);

	Optional<User> findById(Long id);

	User save(User user);
	
}
