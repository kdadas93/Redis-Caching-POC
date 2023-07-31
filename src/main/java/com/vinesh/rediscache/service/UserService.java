package com.vinesh.rediscache.service;

import java.math.BigInteger;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinesh.rediscache.entity.User;
import com.vinesh.rediscache.repository.UserRepository;

@Service
public class UserService {

	private static final Logger log = LoggerFactory.getLogger(UserService.class);

	@Autowired
	UserRepository userRepository;

	public User getUserById(BigInteger id) {
		log.info("Getting customer information for id {}", id);
		Optional<User> user = userRepository.findById(id);
		return user.orElse(null);
	}

	public User create(User user) {
		return userRepository.save(user);
	}

	public User update(User user) {
		BigInteger id = user.getId();
		User userInDb = getUserById(id);
		if (userInDb != null) {
			return create(user);
		} else {
			return null;
		}
	}
	
	public void delete(BigInteger id) {
		userRepository.deleteById(id);
	}
}
