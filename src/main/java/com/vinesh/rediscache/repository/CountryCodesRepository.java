package com.vinesh.rediscache.repository;

import com.vinesh.rediscache.entity.CountryCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface CountryCodesRepository extends JpaRepository<CountryCode, BigInteger> {

}
