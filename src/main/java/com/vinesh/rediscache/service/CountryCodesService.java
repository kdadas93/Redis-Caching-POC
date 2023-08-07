package com.vinesh.rediscache.service;

import com.vinesh.rediscache.entity.CountryCode;
import com.vinesh.rediscache.repository.CountryCodesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryCodesService {

    private static final Logger log = LoggerFactory.getLogger(CountryCodesService.class);

    @Autowired
    CountryCodesRepository countryCodesRepository;

    @Cacheable(value = "country_codes")
    public List<CountryCode> getCountryCodes(){
        log.info(">> CountryCodes Service: reading countryCodes from datastore");
        return null;
    }

    @Cacheable(value = "country_codes")
    public List<CountryCode> getMasterCountryCodes(){
        log.info(">> CountryCodes Service: reading masterCountryCodes from datastore");
        return countryCodesRepository.findAll();
    }

    @CachePut(value = "country_codes")
    public List<CountryCode> updateCountryCodes(){
        log.info(">> CountryCodes Service: updating countryCodes from datastore");
        return countryCodesRepository.findAll();
    }

    @CacheEvict(value = "country_codes", allEntries = true)
    public void delete(){}




}
