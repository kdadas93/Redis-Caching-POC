package com.vinesh.rediscache.service;

import java.math.BigInteger;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.vinesh.rediscache.entity.User;
import com.vinesh.rediscache.repository.UserRepository;

@Service
public class UserService {

	private static final Logger log = LoggerFactory.getLogger(UserService.class);

	@Autowired
	UserRepository userRepository;

	@Cacheable(value= "users", key="#id")
	public User getUserById(BigInteger id) {
		log.info("Getting customer information for id {}", id);
//		try {
//			TimeUnit.MILLISECONDS.sleep(400);
//		} catch (InterruptedException e) {
//			throw new RuntimeException(e);
//		}
		Optional<User> user = userRepository.findById(id);
		return user.orElse(null);
	}

	public User create(User user) {
		return userRepository.save(user);
	}

	@CachePut(value="users", key="#user.getId()")
	public User update(User user) {
		BigInteger id = user.getId();
		User userInDb = getUserById(id);
		if (userInDb != null) {
			return create(user);
		} else {
			return null;
		}
	}

	@CacheEvict(value= "users", allEntries = false, key="#id")
	public void delete(BigInteger id) {
		userRepository.deleteById(id);
	}
}
