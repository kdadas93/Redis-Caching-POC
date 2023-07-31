package com.vinesh.rediscache.repository;

import com.vinesh.rediscache.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface UserRepository extends JpaRepository<User, BigInteger> {

}
